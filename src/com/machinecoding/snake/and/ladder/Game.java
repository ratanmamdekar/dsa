package com.machinecoding.snake.and.ladder;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> players;
    Player winner;

    Game(){
        initializeBoard();
    }

    private void initializeBoard() {
        board = new Board(10,5,4);
        dice = new Dice(1,6);
        players = new LinkedList<>();
        winner = null;
        addPlayer();
    }

    private void addPlayer() {
        Player player1 = new Player(1,0);
        Player player2 = new Player(2,0);

        players.add(player1);
        players.add(player2);
    }

    public void startGame() {
        while (winner == null){

            //check whose turn
            Player player = findPlayerTurn();
            System.out.println("Player id " + player.getId() + ", current position " + player.getCurrentPosition());

            //roll dice
            int diceNumber = dice.rollDice();

            //make move
            if (isValidMove(player,diceNumber)){
                movePlayer(player,diceNumber);
            }
            else {
                System.out.println("Unable to move, that's a bummer!");
            }

            //End turn
            endPlayerTurn(player);

            //check winner
            winner = checkWinner(player);
        }

        System.out.println("Game over, player " + winner.getId() + " wins!!");
    }

    private void endPlayerTurn(Player player) {
        players.add(player);
        System.out.println("Player id " + player.getId() + ", new position " + player.getCurrentPosition()+"\n");
    }

    private Player checkWinner(Player player) {
        if(board.isWinner(player))
            return player;
        else
            return null;
    }

    private void movePlayer(Player player, int diceNumber) {
        int newPosition = player.getCurrentPosition()+diceNumber;
        player.setCurrentPosition(newPosition);
        Jump jump = board.getJump(newPosition);
        if(Objects.nonNull(jump)){
            jumpPlayer(player,jump);
        }
    }

    private void jumpPlayer(Player player, Jump jump) {
        System.out.println(jumpMovePopup(jump));
        player.setCurrentPosition(jump.getEnd());
    }

    private String jumpMovePopup(Jump jump) {
        StringBuilder sb = new StringBuilder();
        sb.append(jump.getStart() > jump.getEnd()?"snake":"ladder");
        sb.append("!!! now move from ");
        sb.append(jump.getStart());
        sb.append(" to ");
        sb.append(jump.getEnd());

        return sb.toString();
    }

    private boolean isValidMove(Player player, int diceNumber) {
        return board.isValidMove(player,diceNumber);
    }

    private Player findPlayerTurn() {
        return this.players.pollFirst();
    }
}
