package Atlassian_week5;

import java.util.*;
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n=g.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int l=0,r=0;
        while(l<s.length&&r<g.length){
            if(s[l]>=g[r]){
                r=r+1;
            }
            l=l+1;
        }
        return r;
    }
}