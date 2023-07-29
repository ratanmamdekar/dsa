package com.lld.zeta;

public class Player {
    String name;
    int score;
    int position;

    public Player(String playerName){
        this.name = playerName;
        this.score =0;
        this.position = -1;
    }

    public void addPoints(int points){
        this.score += points;
    }

    public int updatePostion(int noOfMovesToMove){
        this.position += noOfMovesToMove;
        return this.position;
    }

    public int getScore(){
        return score;
    }

    public String getName() {
        return name;
    }
}
