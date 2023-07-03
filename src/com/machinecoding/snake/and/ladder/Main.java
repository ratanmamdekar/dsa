package com.machinecoding.snake.and.ladder;

/*
Requirement Clarification:
    how many dice? 1: but should be scalable
    how many snakes and ladders? dynamically set during setup
    winning condition? any one player wins,
    Player starts at 0 and rolls dice to move from 1 to 100;

Objects:
    Dice
    Snake/Ladder
    Board
    Players
    Cells


*/
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
