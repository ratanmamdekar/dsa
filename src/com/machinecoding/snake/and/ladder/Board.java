package com.machinecoding.snake.and.ladder;

import java.util.Objects;
import java.util.Random;

public class Board {
    Cell[] cells;
    int totalNumberOfCells;

    Board(int boardSize, int numberOfSnakes, int numberOfLadders){
        totalNumberOfCells= boardSize * boardSize + 1;
        initializeBoard();
        addSnakesAndLadders(cells,numberOfSnakes,numberOfLadders);
    }

    private void addSnakesAndLadders(Cell[] cells, int numberOfSnakes, int numberOfLadders) {
        Random random = new Random();

        while (numberOfSnakes>0){
            int snakeHead = random.nextInt(totalNumberOfCells);
            int snakeTail = random.nextInt(totalNumberOfCells);
            if(snakeHead<snakeTail || snakeHead==100)
                continue;

            Jump snake = new Jump(snakeHead,snakeTail);
            cells[snakeHead].setJump(snake);
            numberOfSnakes--;
        }

        while (numberOfLadders>0){
            int ladderStart = random.nextInt(totalNumberOfCells);
            int ladderEnd = random.nextInt(totalNumberOfCells);
            if(ladderStart>=ladderEnd)
                continue;

            Jump ladder = new Jump(ladderStart,ladderEnd);
            cells[ladderStart].setJump(ladder);
            numberOfLadders--;
        }
    }

    private void initializeBoard() {
        cells = new Cell[totalNumberOfCells];

        for(int cellNumber=0; cellNumber<totalNumberOfCells; cellNumber++)
            cells[cellNumber] = new Cell();
    }

    public boolean isWinner(Player player){
        int lastCell = totalNumberOfCells-1;

        if (player.getCurrentPosition()==lastCell)
            return true;
        else
            return false;
    }


    public boolean isValidMove(Player player, int diceNumber) {
        if(player.getCurrentPosition()+diceNumber>=totalNumberOfCells)
            return false;
        return true;
    }

    public Jump getJump(int newPosition) {
        Jump jump = cells[newPosition].getJump();
        if(Objects.nonNull(jump))
            return jump;
        else
            return null;
    }
}
