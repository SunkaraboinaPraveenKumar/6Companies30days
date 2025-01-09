import java.util.*;
class Solution {
    class Pair{
        int row,col,t;
        public Pair(int row,int col,int t){
            this.row=row;
            this.col=col;
            this.t=t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        int count=0;
        int freshCount=0,ans_time=0;
        int[][] vis=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else if(grid[i][j]==1){
                    freshCount++;
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        int[][] dir={{0,1},{0,-1},{-1,0},{1,0}};
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int row=curr.row;
            int col=curr.col;
            int time=curr.t;
            ans_time=Math.max(ans_time,time);
            for(int d[]:dir){
                int r=row+d[0];
                int c=col+d[1];
                if(r>=0&&c>=0&&r<m&&c<n&&vis[r][c]==0&&grid[r][c]==1){
                    vis[r][c]=2;
                    q.add(new Pair(r,c,time+1));
                    count++;
                }
            }
        }
        if(freshCount!=count){
            return -1;
        }
        return ans_time;
    }
}