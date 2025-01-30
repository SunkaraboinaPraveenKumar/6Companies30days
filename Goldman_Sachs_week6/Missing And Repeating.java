package Goldman_Sachs_week6;
import java.util.*;


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
        // code here
        Arrays.sort(arr);
        int n=arr.length;
        int arrSum=0;
        int duplicate=0;
        for(int i=0;i<n;i++){
            if(i!=0){
                if(arr[i]==arr[i-1]){
                    duplicate=arr[i];
                }
            }
            arrSum+=arr[i];
        }
        int totalSum=n%2==0?(n/2)*(n+1):n*((n+1)/2);
        arrSum-=duplicate;
        return new int[]{duplicate,totalSum-arrSum};
    }
}
