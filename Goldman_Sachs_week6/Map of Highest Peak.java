package Goldman_Sachs_week6;
import java.util.*;
class Solution {
    int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] highestPeak(int[][] isWater) {
        int m=isWater.length;
        int n=isWater[0].length;
        boolean[][] vis=new boolean[m][n];
        int[][] ans=new int[m][n];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j]==1){
                    vis[i][j]=true;
                    q.add(new int[]{i,j,0});
                }
                else{
                    vis[i][j]=false;
                }
            }
        }
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            int steps=curr[2];
            ans[r][c]=steps;
            for(int[] d:dir){
                int row=r+d[0];
                int col=c+d[1];
                if(row>=0&&col>=0&&row<m&&col<n&&!vis[row][col]){
                    vis[row][col]=true;
                    q.add(new int[]{row,col,steps+1});
                }
            }
        }
        return ans;
    }
}
