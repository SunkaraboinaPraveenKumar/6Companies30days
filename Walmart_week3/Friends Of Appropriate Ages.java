package Walmart_week3;
import java.util.*;
class Solution {
    public int numFriendRequests(int[] ages) {
        int reqCount=0;
        Arrays.sort(ages);
        for(int i=0;i<ages.length;i++){
            int minAge=ages[i]/2+7;
            if(minAge<ages[i]){
                int left=binarySearch(ages,0,ages.length,minAge);
                int right=binarySearch(ages,0,ages.length,ages[i])-1;
                reqCount+=right-left;
            }
        }
        return reqCount;
    }
    public int binarySearch(int[] ages,int l,int r,int target){
        while(l<r){
            int mid=l+(r-l)/2;
            if(ages[mid]>target){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
}
