package Walmart_week3;
import java.util.*;
class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean eow;
        public TrieNode(){
            this.children=new TrieNode[26];
            this.eow=false;
        }
    }
    TrieNode root=new TrieNode();
    public void insert(String str){
        TrieNode node=root;
        for(char ch:str.toCharArray()){
            int idx=ch-'a';
            if(node.children[idx]==null){
                node.children[idx]=new TrieNode();
            }
            node=node.children[idx];
        }
        node.eow=true;
    }
    // public boolean helper(String str){
    //     TrieNode node=root;
    //     for(int i=0;i<str.length();i++){
    //         int idx=str.charAt(i)-'a';
    //         if(node.children[idx]==null){
    //             return false;
    //         }
    //         else{
    //             node=node.children[idx];
    //         }
    //         if(node.eow==true){
    //             if(i==str.length()-1||helper(str.substring(i+1))){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
    public boolean helper(String s){
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[n]=true;
        for(int i=n-1;i>=0;i--){
            TrieNode node=root;
            for(int j=i;j<n;j++){
                int idx=s.charAt(j)-'a';
                if(node.children[idx]==null){
                    break;
                }
                else{
                    node=node.children[idx];
                }
                if(node.eow&&dp[j+1]){
                    dp[i]=true;
                }
            }
        }
        return dp[0];
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        for(String str:wordDict){
            insert(str);
        }
        return helper(s);
    }
}
