package Atlassian_week5;
import java.util.*;
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count=0;
        Arrays.sort(arr2);
        for(int i=0;i<arr1.length;i++){
            if(binarySearch(arr2,arr1[i],d)){
                count++;
            }
        }
        return count;
    }
    public boolean binarySearch(int[] nums,int num,int d){
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(Math.abs(num-nums[mid])<=d){
                return false;
            }
            if(nums[mid]<num){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return true;
    }
}