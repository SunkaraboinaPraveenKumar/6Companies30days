package Walmart_week3;
import java.util.*;
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        for(String str:words){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        PriorityQueue<String> pq=new PriorityQueue<>((a,b)->(map.get(a)!=map.get(b))?map.get(a)-map.get(b):b.compareTo(a));
        // pq.addAll(map.keySet());
        List<String> ans=new ArrayList<>();
        // while(!pq.isEmpty()&&k>0){
        //     ans.add(pq.poll());
        //     k--;
        // }
        for(String key:map.keySet()){
            pq.add(key);
            if(pq.size()>k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}
