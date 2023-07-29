package com.lld.tictactoe.model;

import lombok.Getter;

@Getter
public class PlayingPiece {
    PlayingPieceType piece;

    PlayingPiece(PlayingPieceType piece){
        this.piece=piece;
    }
}
