package com.dsa.slidingwindow.fixed;

import java.util.HashMap;
import java.util.Map;

public class anagram {
    public static void main(String[] args) {
        String s = "foxnxfosofxoxfw";
        String p = "fox";
        int k = p.length();
        Map<Character,Integer> counter = new HashMap<>();
        for(char c : p.toCharArray())
            counter.merge(c,1,(v1,v2)->v1+v2);

        int count = counter.size();

        int i=0,j=0,ans=0;

        while(j<s.length()){
            char c = s.charAt(j);
            counter.computeIfPresent(c,(key,val)->val-1);
            if(counter.getOrDefault(c,-1)==0)
                count--;

            if(j-i+1<k)
                j++;
            else {
                if (count==0)
                    ans++;
                c = s.charAt(i);
                counter.computeIfPresent(c,(key,val)->val+1);
                if(counter.getOrDefault(c,-1)==1)
                    count++;
                i++;
                j++;
            }

        }

        System.out.println(ans);
    }
}
