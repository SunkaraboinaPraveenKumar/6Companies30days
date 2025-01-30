package Goldman_Sachs_week6;
import java.util.*;
class Solution{
    static String printMinNumberForPattern(String s){
        // code here
        int n=s.length();
        String result="";
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<=n;i++){
            st.push(i+1);
            if(i==n||s.charAt(i)=='I'){
                while(!st.isEmpty()){
                    result+=st.pop()+"";
                }
            }
        }
        return result;
    }
}