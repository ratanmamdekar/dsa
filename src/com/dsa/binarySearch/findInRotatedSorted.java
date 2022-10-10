package com.dsa.binarySearch;

public class findInRotatedSorted {
    public static void main(String[] args) {
        int [] nums ={11,13,15,18,3,5,6,8,10};
        int target = 20;

        int pivot = findPivot(nums);
        System.out.println("pivot at "+pivot);
        int pos ;

        pos = BinarySearch(nums,0,pivot-1,target);
        if(pos==-1)
            pos = BinarySearch(nums,pivot,nums.length-1,target);
        System.out.println("position of "+target+" is "+pos);

    }

    private static int BinarySearch(int[] nums, int i, int i1, int target) {
        int ans=-1,low=i,high=i1;
        while (low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target)
                return mid;
            else if (nums[mid]>target)
                high=mid-1;
            else
                low=mid+1;
        }

        return ans;
    }

    private static int findPivot(int[] nums) {
        int low,high,mid,next,prev;
        low=0;
        int n=nums.length;
        high=n-1;
        while (low<=high){
            if (nums[low]<=nums[high])
            {
                return low;
            }
            mid = (low+high)/2;
            next = (mid+1)%n;
            prev = (mid+n-1)%n;

            if(nums[mid]<=nums[next] && nums[mid]<nums[prev])
                return mid;
            else if(nums[low]<=nums[mid])
                low=mid+1;
            else
                high=mid-1;
        }

        return -1;
    }
}
