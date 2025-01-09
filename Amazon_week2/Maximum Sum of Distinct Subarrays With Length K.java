import java.util.*;
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n=nums.length;
        long maxSum=0;
        int left=0,right=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        long sum=0;
        while(right<n){
            sum+=nums[right];
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(right-left+1>k&&left<=right){
                map.put(nums[left],map.get(nums[left])-1);
                sum-=nums[left];
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }
            if(map.size()==k){
                maxSum=Math.max(maxSum,sum);
            }
            right++;
        }
        return maxSum;
    }
}