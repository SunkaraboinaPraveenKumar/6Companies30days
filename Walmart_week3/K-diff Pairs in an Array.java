package Walmart_week3;
import java.util.*;
class Solution {
    // class Pair{
    //     int i;
    //     int j;
    //     public Pair(int i,int j){
    //         this.i=i;
    //         this.j=j;
    //     }
    // }
    public int findPairs(int[] nums, int k) {
        // int count=0;
        int n=nums.length;
        Arrays.sort(nums);
        HashMap<Integer,Integer> map=new HashMap<>();
        HashSet<String> ans=new HashSet<>();
        for(int i=0;i<n;i++){
            if(i>0&&nums[i]==nums[i-1]){
                if(k==0){
                    ans.add(nums[i]+","+nums[i-1]);
                    // count++;
                }
                continue;
            }
            int num1=nums[i]+k;
            int num2=nums[i]-k;
            if(map.containsKey(num1)){
                // count++;
                ans.add(nums[map.get(num1)]+","+nums[i]);
            }
            if(map.containsKey(num2)){
                // count++;
                ans.add(nums[map.get(num2)]+","+nums[i]);
            }
            map.put(nums[i],i);
        }
        // return count;
        return ans.size();
    }
}
