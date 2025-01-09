import java.util.*;
class Solution {
    Map<String,Integer> memo=new HashMap<>();
    public int maxProfit(int k, int[] prices) {
        return recur(k,prices,0,false,0);
    }
    private int recur(int k,int[] prices, int i,boolean hasStock, int count){
        String s=i+":"+hasStock+":"+count;
        if(memo.containsKey(s)){
            return memo.get(s);
        }
        int res=0;
        if(i>=prices.length||count>=k){
            return res;
        }
        if(hasStock){
            int sell=prices[i]+recur(k,prices,i+1,false,count+1);
            int notsell=recur(k,prices,i+1,true,count);
            res=Math.max(sell,notsell);
        }
        else{
            int buy=recur(k,prices,i+1,true,count)-prices[i];
            int notbuy=recur(k,prices,i+1,false,count);
            res=Math.max(res,Math.max(buy,notbuy));
        }
        memo.put(s,res);
        return res;
    }
}