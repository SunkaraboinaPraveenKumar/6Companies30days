package Atlassian_week5;
import java.util.*;
class Solution {
    public int countCollisions(String dir) {
        if(dir.length()==0){
            return 0;
        }
        while(dir.length()>0&&dir.charAt(0)=='L'){
            dir=dir.substring(1);
        }
        while(dir.length()>0&&dir.charAt(dir.length()-1)=='R'){
            dir=dir.substring(0,dir.length()-1);
        }
        if(dir.length()==0){
            return 0;
        }
        int cnt=0;
        for(char ch:dir.toCharArray()){
            if(ch!='S'){
                cnt++;
            }
        }
        return cnt;
    }
}
