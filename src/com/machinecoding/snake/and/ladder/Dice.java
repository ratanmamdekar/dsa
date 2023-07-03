package com.machinecoding.snake.and.ladder;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Dice {
    int diceCount;
    int max =6;

    public int rollDice(){
        int diceUsed=0,totalSum=0;
        while (diceUsed<diceCount){
            Random random = new Random();
            totalSum += random.nextInt(max) + 1;
            diceUsed++;
        }
        return totalSum;
    }
}
