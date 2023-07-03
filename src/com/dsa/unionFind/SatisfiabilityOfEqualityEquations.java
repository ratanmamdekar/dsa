package com.dsa.unionFind;

public class SatisfiabilityOfEqualityEquations {
    static int[] parent;
    static int[] size;
    public static void main(String[] args) {
//        String[] equations = {"a==b","b!=a"}; //false
        String[] equations = {"a==b","b==a"}; //true
        System.out.println(equationsPossible(equations));
    }

    public static boolean equationsPossible(String[] equations) {
        parent = new int[26];
        size = new int[26];
        DSU bob = new DSU(8);
        for(int i=0;i<26;i++){
            parent[i]=i;
            size[i]=1;
        }

        for(String s:equations){
            if(s.charAt(1)=='='){
                int a = s.charAt(0) -'a';
                int b = s.charAt(3) -'a';

                if(a!=b)
                    union(a,b);
            }
        }

        for(String s:equations){
            if(s.charAt(1)=='!'){
                int a = s.charAt(0) -'a';
                int b = s.charAt(3) -'a';

                if(find(a) == find(b))
                    return false;
            }
        }

        return true;
    }

    public static int find(int a){
        if(parent[a] == a)
            return a;

        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(size[a]>=size[b]){
            parent[b]=a;
            size[a]+=size[b];
        }
        else{
            parent[a]=b;
            size[b]+=size[a];
        }
    }


    static class DSU{
        int[] parent;
        int[] size;
        int components;

        DSU(int n){
            components =n;
            parent = new int[n+1];
            size = new int[n+1];

            for(int i=0;i<=n;i++){
                parent[i]=i;
                size[i]=i;
            }
        }

        int find(int n){
            if(parent[n]==n){
                return n;
            }
            return parent[n] = find(parent[n]);
        }

        int union(int a, int b){
            a = find(a);
            b = find(b);

            if(a==b){
                return 0;
            }

            if(size[a]>=size[b]){
                parent[b]=a;
                size[a]+=size[b];
            }else{
                parent[a]=b;
                size[b]+=size[a];
            }

            components--;
            return 1;
        }

        boolean isConnected(){
            return components==1;
        }
    }
}
