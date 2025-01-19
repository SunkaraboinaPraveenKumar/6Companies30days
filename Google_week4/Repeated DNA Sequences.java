import java.util.*;
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> ans=new HashSet<>();
        int left=0,right=0;
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        HashSet<String> set=new HashSet<>();
        while(right<n){
            sb.append(s.charAt(right));
            if(right-left+1==10){
                if(set.contains(sb.toString())){
                    ans.add(sb.toString());
                }
                else{
                    set.add(sb.toString());
                }
                sb.deleteCharAt(0);
                left++;
            }
            right++;
        }
        return new ArrayList<>(ans);
    }
}