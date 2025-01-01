import java.util.*;
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;
        int sum=0,ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i]%2;
            int need=sum-k;
            if(map.containsKey(need)){
                ans+=map.get(need);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}