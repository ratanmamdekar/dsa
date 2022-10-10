package com.dsa.dp.misc;

import java.util.*;

//leetcode Hard - https://leetcode.com/problems/stickers-to-spell-word/
public class InfiniteStickerRansomNote {
    public static void main(String[] args) {
//        String[] stickers = {"with", "example", "science"};
//        String target  = "thehat";
////        ans - 3

/*

        String[] stickers = {"control","heart","interest","stream","sentence","soil","wonder","them","month",
                "slip","table","miss","boat","speak","figure","no","perhaps","twenty","throw","rich","capital",
                "save","method","store","meant","life","oil","string","song","food","am","who","fat","if","put",
                "path","come","grow","box","great","word","object","stead","common","fresh","the","operate"
                ,"where","road","mean"};
        String target  ="stoodcrease";
//        ans - 3
*/

        String[] stickers = {"old","center","shape","fig","skin","come"};
        String target = "togethernear";

        System.out.println(minStickers(stickers,target));
    }

    // partially correct
    public static int minStickers(String[] stickers, String target) {
        List<Map<Character,Integer>> stickerCharaterCount = new ArrayList<>();
        List<Map<Integer,Integer>> dp = new ArrayList<>();

        for(String sticker : stickers) {
            stickerCharaterCount.add(getCharaterCount(sticker));
            dp.add(new HashMap<>());
        }

        Map<Character,Integer> targetCharCount = getCharaterCount(target);

        return helper(stickers.length-1,stickerCharaterCount,targetCharCount,targetCharCount.size(),dp);
    }

    public static int helper(int idx,List<Map<Character,Integer>> stickers,
                             Map<Character,Integer> target,int targetSize, List<Map<Integer,Integer>> dp){
        if(targetSize==0)
            return 0;
        if(idx<0)
            return (int)1e9;

        if(dp.get(idx).containsKey(target.hashCode()) && 1e9!=dp.get(idx).get(target.hashCode()))
            return dp.get(idx).get(target.hashCode());


        Map<Character,Integer> sticker = stickers.get(idx);

        boolean takenAtleastOne = false;
        for(char ch : sticker.keySet()){
            if(target.containsKey(ch)){
                int sVal = sticker.get(ch);
                int tVal = target.get(ch);
                if(tVal>0)
                    takenAtleastOne = true;
                if(tVal>0 && tVal-sVal<=0)
                    targetSize--;
                target.put(ch,tVal-sVal);
            }
        }

        int take = (int)1e9;

        if(takenAtleastOne)
            take = 1 + helper(idx,stickers,target,targetSize,dp);

        for(char ch : sticker.keySet()){
            if(target.containsKey(ch)){
                int sVal = sticker.get(ch);
                int tVal = target.get(ch);
                if(tVal<=0 && tVal+sVal>0)
                    targetSize++;
                target.put(ch,tVal+sVal);
            }
        }

        int notTake = helper(idx-1,stickers,target,targetSize,dp);

        dp.get(idx).put(target.hashCode(),Math.min(take,notTake));
        return dp.get(idx).get(target.hashCode());
    }

    public static Map<Character,Integer> getCharaterCount(String word){
        Map<Character,Integer> charCount = new HashMap<>();
        for(char ch : word.toCharArray())
            charCount.merge(ch,1,(v1,v2)->v1+v2);

        return charCount;
    }

}
