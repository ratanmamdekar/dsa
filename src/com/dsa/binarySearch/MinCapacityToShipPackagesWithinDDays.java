package com.dsa.binarySearch;

public class MinCapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        //ans 15;
        System.out.println(shipWithinDays(weights,days));

        weights = new int[]{3,2,2,4,1,4};
        days = 3;
        //ans 6;
        System.out.println(shipWithinDays(weights,days));
    }

    static int shipWithinDays(int[] weights, int days) {
        int min=1,max=(int)1e9;
        int ans=0;
        while(min<=max){
            int mid = (max+min)/2;
            if(canShip(weights,days,mid)){
                ans=mid;
                max=mid-1;
            }
            else
                min=mid+1;
        }

        return ans;
    }

    static boolean canShip(int[] weights, int days, int cap) {
        int d=0,i=0,n=weights.length;

        while(i<n){
            int sum=weights[i];
            if(sum>cap)
                return false;
            i++;
            while(i<n && sum+weights[i]<=cap){
                sum+=weights[i];
                i++;
            }
            d++;
        }
        return d<=days;
    }
}
