package Walmart_week3;
import java.util.*;
class Solution {
    public String frequencySort(String s) {
        int n=s.length();
        // Character[] arr=new Character[n];
        // int k=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            // arr[k++]=ch;
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        // Arrays.sort(arr,(a,b)->map.get(b)-map.get(a));
        // return new String(ar);
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        pq.addAll(map.keySet());
        StringBuilder ans=new StringBuilder();
        while(!pq.isEmpty()){
            char ch=pq.poll();
            int freq=map.get(ch);
            for(int i=0;i<freq;i++){
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}
