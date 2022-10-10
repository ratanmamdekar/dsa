package com.dsa.slidingwindow.variable;

public class LongestSubstringWithKUniqueChar {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k =3;
        char c;
        int i=0,j=0,ans=0,count=0;
        int[] counter = new int[26];
        while(j<s.length()){
            c = s.charAt(j);
            counter[c-'a']++;
            if(counter[c-'a']==1)
                count++;

            if (count<k)
                j++;
            else if(count==k) {
                ans = Math.max(ans, j - i + 1);
                j++;
            }
            else {
                while(count>k){
                    c = s.charAt(i);
                    counter[c-'a']--;
                    if(counter[c-'a']==0)
                        count--;
                    i++;
                }
                j++;
            }

        }

        System.out.println(ans);
    }
}
