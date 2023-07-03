package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }

    static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        helper(s,0,new ArrayList<>(),ans);

        return ans;
    }

    static void helper(String s, int ind, List<String> list,List<List<String>> ans){
        if(ind==s.length())
            ans.add(new ArrayList<>(list));
        else{
            for(int p=ind+1;p<=s.length();p++){
                String sub = s.substring(ind,p);
                if(isP(sub,0)){
                    // System.out.println(sub);
                    list.add(sub);
                    helper(s,p,list,ans);
                    list.remove(list.size()-1);
                }
            }
        }
    }

    static boolean isP(String s,int i){
        if(i>=s.length()/2)
            return true;
        return s.charAt(i)==s.charAt(s.length()-1-i) && isP(s,i+1);
    }
}
