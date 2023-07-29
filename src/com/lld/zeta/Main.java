package com.lld.zeta;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> cellStings = getCellStrings();
        Game game = new Game(4,cellStings.size(),10,cellStings);

        game.startGame();

        game.getWinner();
    }

    private static List<String> getCellStrings() {
        List<String> cellStings = new ArrayList<>();
        cellStings.add("H");
        cellStings.add("T");
        cellStings.add("N");
        cellStings.add("N");
        cellStings.add("N");
        cellStings.add("H");
        cellStings.add("T");
        cellStings.add("J");
        cellStings.add("N");
        cellStings.add("N");
        return cellStings;
    }

}
