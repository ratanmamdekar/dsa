package com.lld.tictactoe;

import com.lld.tictactoe.model.Board;
import com.lld.tictactoe.model.Player;
import com.lld.tictactoe.model.PlayingPieceO;
import com.lld.tictactoe.model.PlayingPieceX;

import java.util.*;

public class TicTacToeGame {
    Board board;
    Queue<Player> playerList;
    Player winner;

    public void initialize() {
        Player p1 = new Player("player1",new PlayingPieceO());
        Player p2 = new Player("player1",new PlayingPieceX());
        playerList= new LinkedList<>();
        playerList.offer(p1);
        playerList.offer(p2);

        board = new Board(3);

        winner=null;
    }


    public String getWinner() {
        if(Objects.isNull(winner)){
            return "oops that was tie";
        }
        return "winner is " + winner.getName();
    }

    public void startGame() {
        while(Objects.isNull(winner)){
            Player currentPlayer = playerList.peek();

            if(board.isBoardFull()){
                System.out.println("board full");
                return;
            }
            board.printBoard();
            System.out.println("enter row and col for playing your piece "+currentPlayer.getPiece().getPiece());
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            boolean successfullyPlaced = board.placePiece(inputRow, inputColumn, currentPlayer.getPiece());

            if(!successfullyPlaced){
                System.out.println("Incorrect position. Please retry");
                continue;
            }
            playerList.offer(playerList.poll());

            boolean isWinner = board.isWinner(currentPlayer);
            if (isWinner){
                winner = currentPlayer;
                System.out.println("winner found");
                return;
            }
        }
        System.out.println("no winner found");

    }
}
