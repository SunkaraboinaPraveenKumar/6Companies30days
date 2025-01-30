package Goldman_Sachs_week6;
import java.util.*;
class Solution {
    HashSet<List<Integer>> ans=new HashSet<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k,new ArrayList<>(),new int[1],n,new boolean[10]);
        return new ArrayList<>(ans);
    }
    public void backtrack(int k,List<Integer> list,int[] sum,int n,boolean[] used){
        if(list.size()>k){
            return;
        }
        if(list.size()==k&&sum[0]==n){
            List<Integer> temp=new ArrayList<>(list);
            Collections.sort(temp);
            if(!ans.contains(temp)){
                ans.add(temp);
            }
            return;
        }
        for(int i=1;i<=9;i++){
            if(!used[i]){
                list.add(i);
                used[i]=true;
                sum[0]+=i;
                backtrack(k,list,sum,n,used);
                used[i]=false;
                sum[0]-=i;
                list.remove(list.size()-1);
            }
        }
    }
}
