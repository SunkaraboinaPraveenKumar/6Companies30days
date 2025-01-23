package Atlassian_week5;
import java.util.*;
class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        HashSet<Integer> setMasks=new HashSet<>();
        for(String str:startWords){
            setMasks.add(getMask(str));
        }
        int count=0;
        for(String target:targetWords){
            int targetMask=getMask(target);
            for(int i=0;i<26;i++){
                if((targetMask&(1<<i))!=0){
                    int newMask=targetMask^(1<<i);
                    if(setMasks.contains(newMask)){
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
    public int getMask(String str){
        int mask=0;
        for(char ch:str.toCharArray()){
            mask|=(1<<ch-'a');
        }
        return mask;
    }
}
