package com.dsa.Trie;

import java.util.*;

public class wordTrie {
        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            Trie words = new Trie();
            for(String word : products){
                words.addWord(0,word,words);
            }
            List<List<String>> ans = new ArrayList<>();

            for(int i=0;i<searchWord.length();i++){
                List<String> top3 = new ArrayList<>();
                words.findNode(0,i,searchWord,top3);
                ans.add(top3);
            }
            return ans;
        }

        public class Trie{
            boolean isWord;
            Trie[] letters;

            Trie(){
                isWord=false;
                letters = new Trie[26];
            }

            public void addWord(int index, String word, Trie trie){
                if(index==word.length())
                    trie.isWord=true;
                else{
                    if(Objects.isNull(trie.letters[word.charAt(index)-'a']))
                        trie.letters[word.charAt(index)-'a'] = new Trie();
                    addWord(index+1,word,trie.letters[word.charAt(index)-'a']);
                }
            }

            public void findNode(int curr, int index, String word, List<String> top3){
                if(curr>index)
                    findTop3(top3,new StringBuilder(word.substring(0,curr)));
                else{
                    if(Objects.isNull(this.letters[word.charAt(curr)-'a'])){
                        return;
                    }
                    else{
                        Trie next = this.letters[word.charAt(curr)-'a'];
                        next.findNode(curr+1,index,word,top3);
                    }
                }
            }

            public void findTop3(List<String> top3,StringBuilder sb){
                if(top3.size()>=3)
                    return;
                if(this.isWord)
                    top3.add(sb.toString());
                for(int i=0;i<26;i++){
                    if(!Objects.isNull(this.letters[i])){
                        Trie next = this.letters[i];
                        sb.append((char) ('a'+i));
                        next.findTop3(top3,sb);
                        sb.deleteCharAt(sb.length()-1);
                    }
                }
            }

        }

    public static void main(String[] args) {
        wordTrie wordTrie = new wordTrie();
        String[] words ={"mobile","mouse","moneypot","monitor","mousepad"};
        System.out.println(wordTrie.suggestedProducts(words,"mouse"));

        StringBuilder sb = new StringBuilder();
        System.out.println(sb.indexOf("abc"));
        for(String a : words)
            System.out.println(a);
    }
}