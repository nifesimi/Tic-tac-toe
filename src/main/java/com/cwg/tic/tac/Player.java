package com.cwg.tic.tac;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Chukwudum Ekwueme
 * @email *: chidumekekwueme@gmail.com, chukwudum.ekwueme@cwlgroup.com
 * @date **: 11/10/17 12:36 PM
 * -------------------------------------------------------------
 */

public class Player {

    private String name;
    private List<String> indexesOfTilesPlayed;

    public Player(String name){
        this.name = name;
        indexesOfTilesPlayed = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public List<String> getPlays(){
        return indexesOfTilesPlayed;
    }
}
