package com.lld.tictactoe;

public class Main {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.initialize();
        game.startGame();
        System.out.println(game.getWinner());

    }
}
