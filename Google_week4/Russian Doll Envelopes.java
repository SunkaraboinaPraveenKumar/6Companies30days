import java.util.*;
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->a[0]!=b[0]?a[0]-b[0]:b[1]-a[1]);
        int n=envelopes.length;
        int[] heights=new int[n];
        for(int i=0;i<n;i++){
            heights[i]=envelopes[i][1];
        }
        List<Integer> lis=new ArrayList<>();
        for(int h:heights){
            int pos=Collections.binarySearch(lis,h);
            if(pos<0){
                pos=-(pos+1);
            }
            if(pos<lis.size()){
                lis.set(pos,h);
            }
            else{
                lis.add(h);
            }
        }
        return lis.size();
    }
}