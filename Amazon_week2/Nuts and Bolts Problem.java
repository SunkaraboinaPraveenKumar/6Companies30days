import java.util.*;
class Solution {
    void matchPairs(int n, char nuts[], char bolts[]) {
        // code here
        HashMap<Character,Integer> priority=new HashMap<>();
        char[] arr = { '!','#','$','%','&','*','?','@','^'};
        int k=1;
        for(char ch:arr){
            priority.put(ch,k++);   
        }
        Character[] nut=new Character[n];
        Character[] bolt=new Character[n];
        for(int i=0;i<n;i++){
            nut[i]=nuts[i];
            bolt[i]=bolts[i];
        }
        Arrays.sort(nut,(a,b)->priority.get(a)-priority.get(b));
        Arrays.sort(bolt,(a,b)->priority.get(a)-priority.get(b));
        for(int i=0;i<n;i++){
            nuts[i]=nut[i];
            bolts[i]=bolt[i];
        }
    }
}