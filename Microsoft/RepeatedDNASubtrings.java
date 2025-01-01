import java.util.*;
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        StringBuilder sb=new StringBuilder();
        int left=0,right=0;
        int n=s.length();
        HashSet<String> set=new HashSet<>();
        HashMap<String,Integer> map=new HashMap<>();
        while(right<n){
            sb.append(s.charAt(right));
            if(right-left+1==10){
                map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
                if(map.get(sb.toString())>1){
                    set.add(sb.toString());
                }
                sb.deleteCharAt(0);
                left++;
            }
            right++;
        }
        return new ArrayList<>(set);
    }
}