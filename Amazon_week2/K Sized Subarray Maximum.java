import java.util.*;
class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int arr[], int k) {
        // Your code here
        ArrayList<Integer> ans=new ArrayList<>();
        int left=0;
        int right=0;
        int max=Integer.MIN_VALUE;
        // PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int n=arr.length;
        int maxIdx=-1;
        while(right<n){
            // pq.add(arr[right]);
            // if(right-left+1==k&&!pq.isEmpty()){
            //     ans.add(pq.peek());
            //     pq.remove(arr[left]);
            //     left++;
            // }
            // right++;
            if(arr[right]>=max){
                maxIdx=right;
                max=arr[right];
            }
            if(right-left+1==k){
                ans.add(max);
                left++;
                if(maxIdx<left){
                    max=Integer.MIN_VALUE;
                    for(int i=left;i<=right;i++){
                        if(arr[i]>max){
                            max=arr[i];
                            maxIdx=i;
                        }
                    }
                }
            }
            right++;
        }
        return ans;
    }
}