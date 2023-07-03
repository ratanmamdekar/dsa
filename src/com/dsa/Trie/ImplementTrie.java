package com.dsa.Trie;

public class ImplementTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("apps");
        trie.insert("alex");
        System.out.println(trie.search("apps"));
        System.out.println(trie.search("apss"));
        System.out.println(trie.startsWith("al"));
        System.out.println(trie.startsWith("bl"));
    }
    static class Trie {
        Node root;
        class Node{
            Node[] child;
            boolean wordEnds;

            Node(){
                wordEnds=false;
                child = new Node[26];
            }
        }

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node node = root;
            for(char c:word.toCharArray()){
                if(node.child[c-'a']==null)
                    node.child[c-'a']=new Node();
                node = node.child[c-'a'];
            }
            node.wordEnds=true;
        }

        public boolean search(String word) {
            Node node = root;
            for(char c:word.toCharArray()){
                if(node.child[c-'a']==null)
                    return false;
                node = node.child[c-'a'];
            }
            return node.wordEnds;
        }

        public boolean startsWith(String prefix) {
            Node node = root;
            for(char c:prefix.toCharArray()){
                if(node.child[c-'a']==null)
                    return false;
                node = node.child[c-'a'];
            }
            return node!=null;
        }
    }
}
