package com.lld.zeta;

public class Cell {
    CellType cellType;

    public Cell(CellType cellType){
        this.cellType = cellType;
    }

    public CellType getCellType(){
        return cellType;
    }
}
