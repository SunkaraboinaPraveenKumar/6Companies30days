import java.util.*;
class Solution {
    public int longestMountain(int[] arr) {
        int n=arr.length;
        if(n<3){
            return 0;
        }
        int[] lis=new int[n];
        int[] lds=new int[n];
        int max=0;
        Arrays.fill(lis,1);
        Arrays.fill(lds,1);
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]){
                lis[i]=lis[i-1]+1;
            }
        }
        for(int i=n-2;i>=0;i--){
            if(arr[i]>arr[i+1]){
                lds[i]=lds[i+1]+1;
            }
        }
        for(int i=1;i<n-1;i++){
            if(lis[i]>1&&lds[i]>1){
                max=Math.max(max,lis[i]+lds[i]-1);
            }
        }
        return max;
    }
}