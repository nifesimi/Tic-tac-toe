package com.cwg.tic.tac;

/**
 * @author : Fatunke Nifesimi
 * @email *: nife.fatunke@gmail.com 
 * @date **: 11/10/17 12:36 PM
 * -------------------------------------------------------------
 */

public class Tile {

    public boolean checked;

    //either X or O
    public String tileMarker;

    public Tile(){
        this.checked = false;
    }


    public void setTileMarker(String tileMarker){

        tileMarker = tileMarker;
    }



    public boolean selectTile(int playerNumber){
        if(playerNumber == 1){
            this.tileMarker = "X";
            this.checked = true;
        }else{

            this.tileMarker = "Y";
            this.checked = true;
        }

        return true;

    }
}
