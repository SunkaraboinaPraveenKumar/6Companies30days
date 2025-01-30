package Goldman_Sachs_week6;
import java.util.*;
class Solution {
    public static String encode(String s) {
        // code here
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<s.length()){
            sb.append(s.charAt(i));
            int cnt=1;
            int j=i+1;
            while(j>0&&j<s.length()&&s.charAt(j)==s.charAt(j-1)){
                j++;
                cnt++;
            }
            sb.append(cnt);
            i=j;
        }
        return sb.toString();
    }
}