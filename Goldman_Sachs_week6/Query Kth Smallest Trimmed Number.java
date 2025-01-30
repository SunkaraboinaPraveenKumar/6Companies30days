package Goldman_Sachs_week6;
import java.util.*;
class Solution {
    class Pair{
        String num;
        int idx;
        public Pair(int idx,String num){
            this.idx=idx;
            this.num=num;
        }
    }
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int len=queries.length;
        int[] ans=new int[len];
        int p=0;
        for(int[] q:queries){
            int k=q[0];
            int trim=q[1];
            PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
                if(a.num.equals(b.num)){
                    return b.idx-a.idx;
                }
                return b.num.compareTo(a.num);
            });
            for(int i=0;i<nums.length;i++){
                String trimmed=nums[i].substring(nums[i].length()-trim);
                pq.add(new Pair(i,trimmed));
                if(pq.size()>k){
                    pq.poll();
                }
            }
            ans[p++]=pq.poll().idx;
        }
        return ans;
    }
}
