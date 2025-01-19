import java.util.*;
class Solution {
    class Pair{
        String str;
        int idx;
        public Pair(String str,int idx){
            this.str=str;
            this.idx=idx;
        }
    }
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n=queries.length;
        int[] ans=new int[n];
        int p=0;
        for(int[] query:queries){
            int k=query[0];
            int trim=query[1];
            PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
                if(a.str.compareTo(b.str)==0){
                    return b.idx-a.idx;
                }
                return b.str.compareTo(a.str);
            });
            for(int i=0;i<nums.length;i++){
                String trimmedStr=nums[i].substring(nums[i].length()-trim);
                pq.add(new Pair(trimmedStr,i));
                if(pq.size()>k){
                    pq.poll();
                }
            }
            ans[p++]=pq.poll().idx;
        }
        return ans;
    }
}