package com.lld.zeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static zeta.CommonConstants.*;

public class Board {
    List<Cell> cells;
    int noOfCells;

    public Board(int noOfCells, List<String> cellsStrings) {
        this.noOfCells = noOfCells;
        this.cells= new ArrayList<>();

        for(int idx =0 ;idx<noOfCells;idx++){
            String cellString = cellsStrings.get(idx);
            Cell cell = createCell(cellString);
            if(Objects.nonNull(cell)){
                this.cells.add(cell);
            }
        }
        this.noOfCells = cells.size();
    }

    Cell getCell(int index){
        //roll over index if it's greater than board size;
        index = index % noOfCells;

        return this.cells.get(index);
    }

    Cell createCell(String cellString){
        switch (cellString){
            case NORMAL_CELL_STRING: return new Cell(CellType.NORMAL_CELL);
            case JAIL_CELL_STRING: return new Cell(CellType.JAIL_CELL);
            case HOTEL_CELL_STRING: return new Cell(CellType.HOTEL_CELL);
            case TREASURE_CELL_STRING: return new Cell(CellType.TREASURE_CELL);
        }
        return null;
    }
}
