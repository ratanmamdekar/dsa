package com.dsa.slidingwindow.variable;

//s = abascbsafjxerasc
//t = bba;
//find minimum window such that all chars of t are present in s with atleast charcount as in t

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "timetopratice";
        String t = "toc";

        int ans =Integer.MAX_VALUE,i=0,j=0,count;
        char ch;
        Map<Character,Integer> tmap = new HashMap<>();
        for(char c:t.toCharArray())
            tmap.merge(c,1,(v1,v2)->v1+v2);
        count= tmap.size();
        int start=-1;
        while (j<s.length()){
            ch = s.charAt(j);
            tmap.computeIfPresent(ch,(key,val)->val-1);
            if(tmap.getOrDefault(ch,-1)==0)
                count--;
            if(count>0){
                j++;
            }
            if(count==0){

                while (count==0){
                    if(ans>j-i+1){
                        ans= j-i+1;
                        start=i;
                    }
                    ch = s.charAt(i);
                    tmap.computeIfPresent(ch,(key,val)->val+1);
                    if(tmap.getOrDefault(ch,-1)==1)
                        count++;
                    i++;
                }
//                j++;
            }
        }

        System.out.println(start==-1?"-1":s.substring(start,start+ans));
    }
}
