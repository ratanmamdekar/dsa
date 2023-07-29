package com.lld.zeta;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    Board board;
    Dice dice;
    Queue<Player> players;
    int noOfPlayers;
    int maxRounds;
    int currentRound;

    public Game(int noOfPlayers, int noOfCells, int numberOfMovesPerPlayer, List<String> cells){
        //create players and add in a queue
        this.noOfPlayers = noOfPlayers;
        createPlayer(noOfPlayers);

        //initialise the board
        this.board = new Board(noOfCells,cells);

        //Set maximum rounds to play
        this.maxRounds = numberOfMovesPerPlayer;

        this.dice = new Dice();
        this.currentRound = 1;
    }

    public void startGame(){
        //start the game
        while (currentRound<=maxRounds){
            System.out.println("starting round " + currentRound);

            for(int playerIdx =0; playerIdx < this.noOfPlayers; playerIdx++){
                //roll dice and make a move
                Player currentPlayer = this.players.poll();
//                currentPlayer.performAction(dice);
                int noOfMovesToMove = dice.rollDice();
                int currentPosition = currentPlayer.updatePostion(noOfMovesToMove);

                //get cell from board and update score
                Cell cell = board.getCell(currentPosition);
                currentPlayer.addPoints(cell.getCellType().getPoint());

                //end of player turn
                this.players.offer(currentPlayer);
            }

            System.out.println("end of round "+currentRound);
            currentRound++;
        }

        System.out.println("End of game");
    }

    public void getWinner(){
        int maxScore= Integer.MIN_VALUE;
        String winnerName ="";

        for(Player player : players){
            if(player.getScore()>maxScore){
                maxScore = player.getScore();
                winnerName = player.getName();
            }else if(player.getScore() == maxScore){
                if(winnerName.compareTo(player.getName())>0){
                    winnerName = player.getName();
                }
            }
        }

        System.out.println("Player "+winnerName+" is the winner with a total score of "+maxScore);
    }

    private void createPlayer(int noOfPlayers) {
        this.players = new LinkedList<>();
        for(Integer playerId =1 ;playerId<=noOfPlayers ; playerId++){
            Player player = new Player((playerId.toString()));
            this.players.offer(player);
        }
    }
}
