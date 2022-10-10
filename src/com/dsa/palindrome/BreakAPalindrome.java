package com.dsa.palindrome;

public class BreakAPalindrome {

    // Break a palindrome by changing only one char. Return smallest one lexicographically. Return "" if not possible.

    public static void main(String[] args) {

        System.out.println(breakPalindrome("abccba"));      //  aaccba
        System.out.println(breakPalindrome("aa"));          //  ab
        System.out.println(breakPalindrome("aba"));         //  abb
    }

    static String breakPalindrome(String palindrome) {
        if(palindrome.length()==1)
            return "";

        StringBuilder sb = new StringBuilder(palindrome);
        boolean allA = true;
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)!='a' && i!=sb.length()/2){
                sb.setCharAt(i,'a');
                allA=false;
                break;
            }
        }
        if(allA)
            sb.setCharAt(sb.length()-1,'b');

        return sb.toString();
    }
}
