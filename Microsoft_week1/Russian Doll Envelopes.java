import java.util.*;

// TLE
// class Solution {
//     public int maxEnvelopes(int[][] envelopes) {
//         Arrays.sort(envelopes,(a,b)->a[0]!=b[0]?a[0]-b[0]:b[1]-a[1]);
//         int n=envelopes.length;
//         int[] dp=new int[n];
//         Arrays.fill(dp,1);
//         int[] heights=new int[n];
//         for(int i=0;i<n;i++){
//             heights[i]=envelopes[i][1];
//         }
//         int max=1;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<i;j++){
//                 if(heights[i]>heights[j]){
//                     dp[i]=Math.max(dp[i],dp[j]+1);
//                     max=Math.max(max,dp[i]);
//                 }
//             }
//         }
//         return max;
//     }
// }


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