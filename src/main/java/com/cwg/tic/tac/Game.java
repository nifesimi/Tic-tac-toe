package com.cwg.tic.tac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : Chukwudum Ekwueme
 * @email *: chidumekekwueme@gmail.com, chukwudum.ekwueme@cwlgroup.com
 * @date **: 11/10/17 12:36 PM
 * -------------------------------------------------------------
 */

public class Game {


    private List<Player> playerList;
    private Board board;
    private Scanner scanner;
    private boolean isPlayer1Turn;
    private List<String> winningCombinations;
    private int PlayerOneCount;
    private int PlayerTwoCount;



    public void start() {
        System.out.println("game has started");
        buildGame(true);
        startGameLoop();
        calculateScores();
        displayScores();

        if(playAgain()){

            restartGame();
        }

    }


    public void restartGame() {
        System.out.println("game has started");
        buildGame(false);
        clearPlayerPlays();
        startGameLoop();
        calculateScores();
        displayScores();
        if(playAgain()){

            restartGame();
        }
    }


    public boolean playAgain() {
        clrScreen();
        System.out.println("Do you want to play again? Y/N");
        String response = scanner.nextLine();

        return ("y".equalsIgnoreCase(response));


    }

    private void buildGame(boolean isTrue) {


        scanner = new Scanner(System.in);

        if (isTrue){
            playerList = new ArrayList<>();
        }

        winningCombinations = new ArrayList<>();
        winningCombinations.add("012");
        winningCombinations.add("345");
        winningCombinations.add("678");
        winningCombinations.add("048");
        winningCombinations.add("036");
        winningCombinations.add("147");
        winningCombinations.add("258");
        winningCombinations.add("246");

        //pause the screen and clear
        pauseScreen();
        clrScreen();
        if(isTrue){
            initializePlayers();
        }
        else {
            getPlayerList();
        }
        clrScreen();
        buildBoard();
    }



  /* public void buildNewGame(){
        scanner = new Scanner(System.in);
        //pause the screen and clear
        pauseScreen();
        clrScreen();
        buildBoard();
        clrScreen();


   }*/


    private void initializePlayers() {
        //build player objects
        for (int i = 1; i <= 2; i++) {
            //add new player
            playerList.add(new Player(getInput("Player " + i + " enter your name")));

        }
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void startGameLoop() {
        isPlayer1Turn = true;
        int playCount = 0;
        boolean gameHasEnded = false;

        while (!gameHasEnded) {

            clrScreen();
            board.showBoard();

            int selectedTileIndex = getPlayerPlay();
            board.getTiles().get(selectedTileIndex).selectTile((isPlayer1Turn) ? 1 : 2);
            Player player = (isPlayer1Turn) ? getPlayer(0) : getPlayer(1);

            //store play
            player.getPlays().add(String.valueOf(selectedTileIndex));

            if (hasPlayerWon(player)) {
                board.showBoard();
                System.out.println(player.getName() + " has won !!!");
                gameHasEnded = true;

            }
            playCount++;


            //check if all tiles have been selected

            if (playCount == 9) {
                System.out.println("Game ends in a draw");
                gameHasEnded = true;
            }


            isPlayer1Turn = !isPlayer1Turn;
        }

    }

    public int getPlayerPlay() {

        boolean validIndex = false;

        int selectedIndex = 0;

        while (!validIndex) {

            String selectedTileIndex;

            if (isPlayer1Turn) {

                selectedTileIndex = getInput(playerList.get(0).getName() + "'s turn.  make a move", false);
            } else {
                selectedTileIndex = getInput(playerList.get(1).getName() + "'s turn. make a move", false);
            }

            try {

                selectedIndex = Integer.valueOf(selectedTileIndex);
                if (selectedIndex < 0 || selectedIndex > 8) {
                    throw new Exception("Invalid tile");
                }

                if (board.getTiles().get(selectedIndex).checked) {
                    System.out.println("tile already selected");
                    throw new Exception("Invalid tile");
                }

                validIndex = true;

            } catch (Exception e) {

                System.out.println("please select a valid tile");
            }

        }

        return selectedIndex;

    }

    private boolean hasPlayerWon(Player player) {

        if (player.getPlays().size() < 3) {
            return false;
        }
        boolean playerWon = false;


        for (String winningCombo : winningCombinations) {

            boolean playerWonCombo = true;

            for (String indexPlayed : player.getPlays()) {

                if (!winningCombo.contains(indexPlayed)) {

                    playerWonCombo = false;
                    break;
                } else {
                }
            }

            if (playerWonCombo) {
                playerWon = true;
                break;
            }

        }

        return playerWon;

    }




    private void buildBoard() {
        board = new Board();

    }



    private String getInput(String prompt, boolean shouldClearScreen) {

        if (shouldClearScreen) {
            clrScreen();

        }
        System.out.print(prompt + " : ");
        String input = scanner.nextLine();
        return input;

    }

    private String getInput(String prompt) {
        return getInput(prompt, true);
    }

    private void pauseScreen() {

        try {

            Thread.sleep(2000);

        } catch (Exception e) {
            //
        }
    }


    /**
     * pass 1 for player one and 2 for player 2
     *
     * @param playerNumber
     * @return
     */
    public Player getPlayer(int playerNumber) {

        return playerList.get(playerNumber);
    }


    public void clrScreen() {
        for (int i = 0; i < 20; i++) {
            System.out.println("\n");
        }
    }

    public void clearPlayerPlays(){

            Player pl = getPlayer(0);
            Player pl2 = getPlayer(1);
            pl.getPlays().clear();
            pl2.getPlays().clear();
    }

    public void calculateScores(){


        int playOneCount = 0;
        int playTwoCount = 0;

        Player pl = getPlayer(0);
        Player pl2 = getPlayer(1);

        if (hasPlayerWon(pl)){
            playOneCount++;

        }
        else if (hasPlayerWon(pl2)){
            playTwoCount++;
        }
        PlayerOneCount += playOneCount;
        PlayerTwoCount += playTwoCount;



    }


    private void displayScores(){

        try{

            Thread.sleep(2000);




        }catch (Exception e){

        }
        clrScreen();

        String playerNames = "  "+ playerList.get(0).getName()+ "           " + playerList.get(1).getName() + "    ";
        String title = "SCORE BOARD";

       // title.length()

        System.out.println("     SCORE BOARD     ");
        System.out.println("-----------------------");
        System.out.println("  "+ playerList.get(0).getName()+ "           " + playerList.get(1).getName() + "    ");
        System.out.println("-------------------------");
        System.out.println("  "+PlayerOneCount+"        |         "+PlayerTwoCount);




    }



}
