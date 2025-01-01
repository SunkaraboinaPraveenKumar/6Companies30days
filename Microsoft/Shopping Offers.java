import java.util.*;
class Solution {
    int min=Integer.MAX_VALUE;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        solve(0,price,special,needs,0);
        return min;
    }
    public void solve(int idx,List<Integer> price,List<List<Integer>> special,List<Integer> needs,int bought){
        if(isFullFilled(needs)){
            min=Math.min(min,bought);
            return;
        }
        if(idx>=special.size()){
            int total=bought;
            for(int i=0;i<needs.size();i++){
                total+=needs.get(i)*price.get(i);
            }
            min=Math.min(min,total);
            return;
        }
        solve(idx+1,price,special,needs,bought);
        if(canBuy(needs,special.get(idx))){
            List<Integer> newNeeds=buyProduct(needs,special.get(idx));
            solve(idx,price,special,newNeeds,bought+special.get(idx).get(needs.size()));
        }
    }
    public boolean isFullFilled(List<Integer> needs){
        for(int need:needs){
            if(need!=0){
                return false;
            }
        }
        return true;
    }
    public boolean canBuy(List<Integer> needs,List<Integer> offer){
        for(int i=0;i<needs.size();i++){
            if(needs.get(i)<offer.get(i)){
                return false;
            }
        }
        return true;
    }
    public List<Integer> buyProduct(List<Integer> needs,List<Integer> offer){
        List<Integer> newNeeds=new ArrayList<>(needs);
        for(int i=0;i<needs.size();i++){
            newNeeds.set(i,needs.get(i)-offer.get(i));
        }
        return newNeeds;
    }
}