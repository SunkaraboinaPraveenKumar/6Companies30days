package Walmart_week3;
import java.util.*;
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int maxLen=1;
        int[] prev_idx=new int[n];
        Arrays.fill(prev_idx,-1);
        int lastIdx=0;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    if(dp[i]<dp[j]+1){
                        dp[i]=dp[j]+1;
                        prev_idx[i]=j;
                    }
                    if(dp[i]>maxLen){
                        maxLen=dp[i];
                        lastIdx=i;
                    }
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(lastIdx!=-1){
            ans.add(nums[lastIdx]);
            lastIdx=prev_idx[lastIdx];
        }
        return ans;
    }
}