package com.dsa.grid;

import java.util.*;

//Pacific -> north and west of grid;
//Atlantic -> south and east of grid;
//find grids from which water can flow to both Pacific and Atlantic
public class PacificAtlanticWaterFlow {
    public static void main(String [] args) {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};

        System.out.println(pacificAtlantic(heights));
    }

    private static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;

        Queue<int[]> pQueue = new LinkedList<>();
        boolean[][] reachP = new boolean[r][c];

        Queue<int[]> aQueue = new LinkedList<>();
        boolean[][] reachA = new boolean[r][c];

        for(int i=0;i<r;i++){
            reachP[i][0]=true;
            pQueue.add(new int[]{i,0});

            reachA[i][c-1]=true;
            aQueue.add(new int[]{i,c-1});
        }
        for(int j=0;j<c;j++){
            reachP[0][j]=true;
            pQueue.add(new int[]{0,j});

            reachA[r-1][j]=true;
            aQueue.add(new int[]{r-1,j});
        }

        BFS(pQueue,heights,reachP);

        BFS(aQueue,heights,reachA);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                if(reachP[i][j] && reachA[i][j])
                    ans.add(new ArrayList<>(Arrays.asList(i,j)));

        return ans;
    }

    private static void BFS(Queue<int[]> queue, int[][] heights, boolean[][] reach) {

        int[] dirRow = {0,0,-1,1};
        int[] dirCol = {1,-1,0,0};

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int idx=0;idx<4;idx++){
                int x = cur[0]+dirRow[idx];
                int y = cur[1]+dirCol[idx];

                if(x>=0 && y>=0 && x<heights.length && y<heights[0].length && !reach[x][y]
                        && heights[x][y]>=heights[cur[0]][cur[1]]){
                    reach[x][y]=true;
                    queue.add(new int[]{x,y});
                }
            }
        }
    }
}
