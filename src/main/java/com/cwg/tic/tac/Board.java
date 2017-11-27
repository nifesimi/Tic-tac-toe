package com.cwg.tic.tac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author : Chukwudum Ekwueme
 * @email *: chidumekekwueme@gmail.com, chukwudum.ekwueme@cwlgroup.com
 * @date **: 11/10/17 12:36 PM
 * -------------------------------------------------------------
 */

public class Board {

    private List<Tile> tiles;

    public Board(){

        tiles = new ArrayList<>();

        for(int i=0; i < 9; i++){
            tiles.add(new Tile());
        }
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void showBoard(){

        System.out.println("board was drawn");



        for(int i = 0; i < 3; i++){
            printRow(i);
            if(i != 2){
                printDivider();
            }

        }


    }

    /**
     * nasty print row method that we are not looking at again
     * @param rowNumber
     */
    private void printRow(int rowNumber){

        int valueIndex = rowNumber * 3;

        for(int i=0; i < 3; i ++){
           // System.out.println("     |     |     ");
            int dividerCounter = 0;
            int horizontalCounter = 0;

            for(int j =0 ; j < 17; j++){

                if(dividerCounter == 5){
                    System.out.print("|");
                    horizontalCounter = 0;
                    dividerCounter = 0;
                    continue;
                }else{
                    if(horizontalCounter == 2 && i==1){
                        //this is a value block
                      //  System.out.print("x");
                        //tile has been checked
                        Tile tile = tiles.get(valueIndex);
                        if(tile.checked){
                            System.out.print(tile.tileMarker);
                        }else{
                            //tile has not been checked
                            System.out.print(String.valueOf(valueIndex));

                        }
                        valueIndex++;

                    }else{
                        System.out.print(" ");
                    }
                    horizontalCounter++;
                }


                dividerCounter++;
            }


            System.out.println("");
        }

       // System.out.println("  x  |  x  |  x  ");

        //System.out.println("     |     |     ");
    }

    private void printDivider(){

        System.out.println("------------------");
    }
}
