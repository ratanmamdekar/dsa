package com.dsa.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class PrintTheLexicographicallySmallestString {
//    You are given a string s and a robot that currently holds an empty string t. Apply one of the following operations until s and t are both empty:
//
//    Remove the first character of a string s and give it to the robot. The robot will append this character to the string t.
//    Remove the last character of a string t and give it to the robot. The robot will write this character on paper.
//    Return the lexicographically smallest string that can be written on the paper.
    public static void main(String[] args) {
        System.out.println(robotWithString("bac"));  // "abc"
        System.out.println(robotWithString("bdda"));  // "addb"
    }

    static String robotWithString(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        int[] last = new int[26];
        Arrays.fill(last,-1);
        for(int i=0;i<s.length();i++)
            last[s.charAt(i)-'a']=i;

        int idx=0;
        for(int i=0;i<26;i++){
            if(last[i]==-1)
                continue;
            char ch = (char)('a'+i);

            while(!stack.isEmpty() && stack.peek()<= ch)
                sb.append(stack.pop());

            while(idx<=last[i]){
                char c =s.charAt(idx++);
                if(c==ch)
                    sb.append(c);
                else
                    stack.push(c);

            }
        }

        while(!stack.isEmpty())
            sb.append(stack.pop());

        return sb.toString();
    }
}
