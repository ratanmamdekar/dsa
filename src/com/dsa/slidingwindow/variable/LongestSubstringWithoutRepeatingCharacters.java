package com.dsa.slidingwindow.variable;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "pwwkew";
        char c,d;
        int i=0,j=0,ans=0;
        int[] counter = new int[26];
        while(j<s.length()){
            c = s.charAt(j);
            counter[c-'a']++;

            if (counter[c-'a']<2){
                ans = Math.max(ans, j - i + 1);
                j++;
            }
            else {
                while(counter[c-'a']>=2){
                    d = s.charAt(i);
                    counter[d-'a']--;
                    i++;
                }
                j++;
            }

        }

        System.out.println(ans);
    }
}
