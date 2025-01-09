import java.util.*;
class Solution {
    public int waysToReachStair(int k) {
        Map<String,Integer> map=new HashMap<>();
        return dfs(1,0,k,false,map);
    }
    private int dfs(int curr,int jump,int k, boolean isBacked,Map<String,Integer> map){
        if(curr<0||(curr>k+1)){
            return 0;
        }
        String memo=curr+":"+jump+":"+isBacked;
        if(map.containsKey(memo)){
            return map.get(memo);
        }
        int res=(curr==k)?1:0;
        if(curr>0&&!isBacked){
            res+=dfs(curr-1,jump,k,true,map);
        }
        res+=dfs(curr+(1<<jump),jump+1,k,false,map);
        map.put(memo,res);
        return res;
    }
}