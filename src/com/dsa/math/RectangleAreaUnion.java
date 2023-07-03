package com.dsa.math;

public class RectangleAreaUnion {
    public static void main(String[] args) {
        int ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2;

        System.out.println(computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2) ); // 45
    }

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        int a1 = (ay2-ay1)*(ax2-ax1);
        int a2 = (by2-by1)*(bx2-bx1);

        if(ax2<bx1 || bx2<ax1 || ay2<by1 || by2<ay1 )
            return a1+a2;

        int x1 = Math.max(ax1,bx1);
        int y1 = Math.max(ay1,by1);
        int x2 = Math.min(ax2,bx2);
        int y2 = Math.min(ay2,by2);

        return a1+a2-(y2-y1)*(x2-x1);
    }
}
