package Atlassian_week5;
import java.util.*;
class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int side=Math.min(getMaxSideConsec(hBars),getMaxSideConsec(vBars));
        return side*side;
    }
    public int getMaxSideConsec(int[] bars){
        Arrays.sort(bars);
        int count=2, res=2;
        for(int i=1;i<bars.length;i++){
            count=(bars[i-1]+1==bars[i])?count+1:2;
            res=Math.max(res,count);
        }
        return res;
    }
}
