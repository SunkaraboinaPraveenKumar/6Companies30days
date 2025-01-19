import java.util.*;
class Solution {
    public int maximumProduct(int[] nums, int k) {
        long mod=1000000007;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int num:nums){
            pq.add(num);
        }
        while(k>0){
            int num=pq.poll();
            pq.add(num+1);
            k--;
        }
        long prod=1L;
        while(!pq.isEmpty()){
            prod=(prod*pq.poll())%mod;
        }
        return (int)(prod%mod);
    }
}