package com.lld.zeta;


import static com.lld.zeta.CommonConstants.*;

public enum CellType {
    NORMAL_CELL(NORMAL_CELL_SCORE),
    JAIL_CELL(JAIL_CELL_SCORE),
    HOTEL_CELL(HOTEL_CELL_SCORE),
    TREASURE_CELL(TREASURE_CELL_SCORE);

    int point;

    CellType(int point) {
        this.point=point;
    }

    public int getPoint() {
        return point;
    }
}
