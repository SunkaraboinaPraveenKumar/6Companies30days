package Atlassian_week5;
import java.util.*;
class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> ans=new ArrayList<>();
        List<Integer> ai=new ArrayList<>();
        List<Integer> bi=new ArrayList<>();
        for(int i=0;i<=s.length()-a.length();i++){
            String sub=s.substring(i,i+a.length());
            if(sub.equals(a)){
                ai.add(i);
            }
        }
        for(int i=0;i<=s.length()-b.length();i++){
            String sub=s.substring(i,i+b.length());
            if(sub.equals(b)){
                bi.add(i);
            }
        }
        for(int idx:ai){
            for(int jdx:bi){
                if(Math.abs(jdx-idx)<=k){
                    ans.add(idx);
                    break;
                }
            }
        }
        return ans;
    }
}
