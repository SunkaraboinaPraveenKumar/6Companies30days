import java.util.*;
class Solution {
    public String getHint(String secret, String guess) {
        int bulls=0;
        int cows=0;
        HashMap<Character,Integer> set=new HashMap<>();
        int k=0;
        for(char ch:secret.toCharArray()){
            if(guess.charAt(k++)==ch){
                bulls++;
            }
            else{
                set.put(ch,set.getOrDefault(ch,0)+1);
            }
        }
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)!=guess.charAt(i)){
                if(set.containsKey(guess.charAt(i))&&set.get(guess.charAt(i))>0){
                    cows++;
                    set.put(guess.charAt(i),set.get(guess.charAt(i))-1);
                }
            }
        }
        return ""+bulls+"A"+""+cows+"B";
    }
}