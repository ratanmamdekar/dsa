package com.lld.tictactoe.model;

import lombok.Getter;

@Getter
public class Player {
    String name;
    PlayingPiece piece;

    public Player(String name, PlayingPiece piece){
        this.name=name;
        this.piece=piece;
    }

}
