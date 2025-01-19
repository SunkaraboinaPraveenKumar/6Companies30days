class Solution {
    int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
    public int minDays(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(isDisconnected(grid)){
            return 0;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    grid[i][j]=0;
                    if(isDisconnected(grid)){
                        return 1;
                    }
                    grid[i][j]=1;
                }
            }
        }
        return 2;
    }
    public boolean isDisconnected(int[][] grid){
        int count=0;
        boolean[][] vis=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1&&!vis[i][j]){
                    count++;
                    if(count>=2){
                        return true;
                    }
                    dfs(i,j,grid,vis);
                }
            }
        }
        return count==0;
    }
    public void dfs(int row,int col,int[][] grid,boolean[][] vis){
        vis[row][col]=true;
        for(int[] d:dir){
            int new_r=row+d[0];
            int new_c=col+d[1];
            if(new_r>=0&&new_c>=0&&new_r<grid.length&&new_c<grid[0].length&&!vis[new_r][new_c]&&grid[new_r][new_c]==1){
                dfs(new_r,new_c,grid,vis);
            }
        }
    }
}