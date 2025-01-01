import java.util.*;
class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isIncremovable(i,j,nums)){
                    count++;
                }
            }
        }
        return count;
    }
    public boolean isIncremovable(int i,int j,int[] nums){
        for(int k=0;k<i-1;k++){
            if(nums[k]>=nums[k+1]){
                return false;
            }
        }
        if(i>0&&j<nums.length-1&&nums[i-1]>=nums[j+1]){
            return false;
        }
        for(int k=j+1;k<nums.length-1;k++){
            if(nums[k]>=nums[k+1]){
                return false;
            }
        }
        return true;
    }
}