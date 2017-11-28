package com.cwg.tic.tac;

/**
 * @author : Chukwudum Ekwueme
 * @email *: chidumekekwueme@gmail.com, chukwudum.ekwueme@cwlgroup.com
 * @date **: 11/10/17 12:35 PM
 * -------------------------------------------------------------
 */

import java.util.Scanner;
public class Application {


    public static void main(String[] args) {
        System.out.println("application started ");
        Scanner input  = new Scanner(System.in);

        //start new game
        Game game = new Game();
         game.start();
         //game.getScores();
         //game.restart();
        /*System.out.println("Do you want to play again? Y/N");
        String in = input.nextLine();

        while (!in.equals("n")) {
            new Game().start();
            System.out.println("Do you want to play again? Y/N");
            in = input.nextLine();

        }*/
    }
}
