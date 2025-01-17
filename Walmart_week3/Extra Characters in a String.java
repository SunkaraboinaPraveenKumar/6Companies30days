package Walmart_week3;
import java.util.*;
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n=s.length();
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        HashSet<String> set=new HashSet<>();
        for(String str:dictionary){
            set.add(str);
        }
        return helper(0,set,s,dp);
    }
    public int helper(int idx,HashSet<String> set, String str,int[] dp){
        if(idx>=str.length()){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int ans=Integer.MAX_VALUE;
        String sub="";
        for(int i=0;i+idx<str.length();i++){
            sub=str.substring(idx,idx+i+1);
            if(set.contains(sub)){
                ans=Math.min(ans,helper(idx+i+1,set,str,dp));
            }
            ans=Math.min(ans,i+1+helper(idx+i+1,set,str,dp));
        }
        return dp[idx]=ans;
    }
}
