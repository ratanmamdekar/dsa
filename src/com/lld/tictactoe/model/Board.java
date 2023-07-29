package com.lld.tictactoe.model;

import java.util.Objects;

public class Board {
    int size;
    PlayingPiece[][] board;

    public Board(int size){
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean placePiece(int inputRow, int inputColumn, PlayingPiece piece) {
        if(inputRow<0 || inputRow>=size || inputColumn<0 || inputColumn>=size ||
                Objects.nonNull(board[inputRow][inputColumn])){
            return false;
        }
        board[inputRow][inputColumn]=piece;
        return true;
    }

    public boolean isWinner(Player currentPlayer) {
        for(int i=0;i<size;i++){
            if(allMatchInRow(i,currentPlayer.getPiece())){
                return true;
            }
        }
        for(int j=0;j<size;j++){
            if(allMatchInCol(j,currentPlayer.getPiece())){
                return true;
            }
        }
        if(primaryDiagMatch(currentPlayer.getPiece())){
            return true;
        }
        if(secondaryDiagMatch(currentPlayer.getPiece())){
            return true;
        }

        return false;
    }

    private boolean primaryDiagMatch(PlayingPiece piece) {
        for(int i=0;i<size;i++){
            if(board[i][i]!=piece){
                return false;
            }
        }
        return true;
    }

    private boolean secondaryDiagMatch(PlayingPiece piece) {
        for(int i=0;i<size;i++){
            if(board[i][size-1-i]!=piece){
                return false;
            }
        }
        return true;
    }

    private boolean allMatchInRow(int i, PlayingPiece piece) {
        for(int j=0;j<size;j++){
            if(board[i][j]!=piece){
                return false;
            }
        }
        return true;
    }

    private boolean allMatchInCol(int j, PlayingPiece piece) {
        for(int i=0;i<size;i++){
            if(board[i][j]!=piece){
                return false;
            }
        }
        return true;
    }

    public boolean isBoardFull() {
        for(int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                if(Objects.isNull(board[i][j])){
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        System.out.println("----------current board-----------");
        for(int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                if(Objects.isNull(board[i][j])){
                    System.out.print(". ");
                }else {
                    System.out.print(board[i][j].piece+" ");
                }
            }
            System.out.println("");
        }
        System.out.println("---------------------------------");
    }
}
