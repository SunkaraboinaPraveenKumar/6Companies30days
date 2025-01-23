package Atlassian_week5;
import java.util.*;
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        int left=0,right=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxLen=0;
        while(right<n){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(left<=right&&map.get(nums[right])>k){
                map.put(nums[left],map.get(nums[left])-1);
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
}
