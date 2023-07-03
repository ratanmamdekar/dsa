package com.dsa.recursion;

import java.util.HashSet;
import java.util.Set;

public class PartitionIntoKEqualSumSubsets {
    public static void main(String[] args) {
        int[] nums = {4,3,2,3,5,2,1};
        int k = 4;

        System.out.println(canPartitionKSubsets(nums,k)); //true
    }
    static boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) return false;
        int sum = 0;
        for (int i : nums) sum += i;
        // basic logic test
        if (sum % k != 0) return false;
        // Arrays.sort(nums);

//        return dfs(nums, new int[k], 0, k, sum / k);   // 20x slower than below;
        return dfs(nums, new boolean[nums.length], k, 0, sum / k, nums.length - 1);
    }

    static boolean dfs(int[] nums, boolean[] visited, int k, int currentSum, int targetSum, int position) {
        // if k is 0, for sure nothing will be left unvisited! this is conclusion from simple math.
        if (k == 0) return true;

        // begin next sum search. Critical point: start search from nums.length - 1, not position!!!
        if (currentSum == targetSum) return dfs(nums, visited, k - 1, 0, targetSum, nums.length - 1);

        for (int i = position; i >= 0; i--) {
            // Skip logic 1:
            // Of course you cannot visit what's already visited.
            if (visited[i]) continue;
            // Skip logic 2:
            // if the last position (i + 1) is not visited, that means it does not work for current combination,
            // and of course this position (i) has same value, it won't work as well, skip it.
            if (i + 1 < nums.length && nums[i] == nums[i + 1] && !visited[i + 1]) continue;
            // Skip logic 3:
            // No need to explain, just out of range case.
            if (currentSum + nums[i] > targetSum) continue;

            // simple recursion and backtracking
            visited[i] = true;
            if (dfs(nums, visited, k, currentSum + nums[i], targetSum, i - 1)) return true;
            visited[i] = false;
        }
        return false;
    }

    static boolean dfs(int[] nums, int[] side, int idx,int k, int max){
        if(idx==nums.length)
            return true;
        else{
            Set<Integer> set = new HashSet<>();
            for(int i=0;i<k;i++){
                if(set.contains(side[i]))
                    continue;
                if(side[i]+nums[idx]>max)
                    continue;
                set.add(side[i]);
                side[i]+=nums[idx];
                if(dfs(nums,side, idx+1,k,max))
                    return true;
                side[i]-=nums[idx];
            }
            return false;
        }
    }
}
