package Walmart_week3;
import java.util.*;
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n=nums.length;
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        List<Integer> temp=new ArrayList<>();
        int tempK=k;
        for(int i=n-1;i>=0&&tempK>0;i--){
            temp.add(arr[i][1]);
            tempK--;
        }
        Collections.sort(temp);
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=nums[temp.get(i)];
        }
        return ans;
    }
}

