package com.cwg.tic.tac;

/**
 * @author : Fatunke Nifesimi
 * @email *: nife.fatunke@gmail.com 
 * @date **: 11/28/17 3:24 PM
 * -------------------------------------------------------------
 */

public class Test {

    public static void main(String[] args) {
        /**
         ------------------------------------
         |      Chidium    |    taintedddd  |
         ------------------------------------
         |        0        |      1         |
         ------------------------------------
         **/


        String[] playerNames = {"francophone", "blender english","disturbed guy"};

        int MIN_CELL_PADDING = 2;
        int MIN_CELL_WIDTH =  16;
        int NUMBER_OF_PLAYERS = playerNames.length;
        int NUMBER_OF_HORIZONTAL_DIVIDERS = NUMBER_OF_PLAYERS + 1;

        String HEADER = "SCORE BOARD";

        int PLAYER_MAX_NAME_LENGTH = 0;

        for(String name : playerNames){
            if(name.length() > PLAYER_MAX_NAME_LENGTH)
                PLAYER_MAX_NAME_LENGTH = name.length();

        }

        int calculatedCellWidth = MIN_CELL_WIDTH;


        if((PLAYER_MAX_NAME_LENGTH + (MIN_CELL_PADDING * 2)) > MIN_CELL_WIDTH){
            calculatedCellWidth = PLAYER_MAX_NAME_LENGTH + (MIN_CELL_PADDING * 2);
        }

        int dividerLength = (calculatedCellWidth * NUMBER_OF_PLAYERS) + NUMBER_OF_HORIZONTAL_DIVIDERS;



        //row 1 header
        repeatCharacter(dividerLength, '-', true);
        System.out.print('|');
        centerText(HEADER,(dividerLength - 2) );
        System.out.print("|\n");
        repeatCharacter(dividerLength, '-', true);




        //row 2 player names

        for(int i = 0 ; i < NUMBER_OF_PLAYERS; i++){
            System.out.print('|');

            centerText(playerNames[i], calculatedCellWidth);

        }
        System.out.print("|\n");
        repeatCharacter(dividerLength, '-', true);

    }

    public static void centerText(String text, int fullTextLength){

        int leftJustify = (fullTextLength - text.length()) / 2;
        repeatCharacter(leftJustify, ' ', false);
        System.out.print(text);
        repeatCharacter(fullTextLength - (leftJustify + text.length()), ' ', false);

    }

    public static int repeatCharacter(int length, char c, boolean addNewLine){

        for(int i = 0 ; i < length ; i++){
            System.out.print(c);
        }
        if(addNewLine){
            System.out.println("");

        }

        return 0;
    }
}
