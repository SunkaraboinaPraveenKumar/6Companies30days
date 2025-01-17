package Walmart_week3;

class Solution {
    int[][] dir={{0,1},{0,-1},{-1,0},{1,0}};
    public int countBattleships(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] vis=new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='X'&&!vis[i][j]){
                    vis[i][j]=true;
                    count++;
                    dfs(i,j,board,vis);
                }
            }
        }
        return count;
    }
    public void dfs(int row,int col,char[][] board,boolean[][] vis){
        for(int d[]:dir){
            int new_r=row+d[0];
            int new_c=col+d[1];
            if(new_r>=0&&new_c>=0&&new_r<board.length&&new_c<board[0].length&&!vis[new_r][new_c]&&board[new_r][new_c]!='.'){
                vis[new_r][new_c]=true;
                dfs(new_r,new_c,board,vis);
            }
        }
    }
}
