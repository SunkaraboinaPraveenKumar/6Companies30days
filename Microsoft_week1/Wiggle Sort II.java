import java.util.*;
class Solution {
    public void wiggleSort(int[] nums) {
        int n=nums.length;
        int[] arr=Arrays.copyOf(nums,n);
        Arrays.sort(arr);
        int len=n-1;
        for(int i=1;i<n;i+=2){
            nums[i]=arr[len--];
        }
        for(int i=0;i<n;i+=2){
            nums[i]=arr[len--];
        }
    }
}