import java.util.*;
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // row check
        for(int i=0;i<9;i++){
            if(!isValidRow(board[i])){
                return false;
            }
        }
        // col check
        for(int i=0;i<9;i++){
            if(!isValidCol(i,board)){
                return false;
            }
        }
        // sub grid check
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                if(!isSubGrid(i,j,board)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValidRow(char[] row){
        HashSet<Character> set=new HashSet<>();
        for(char ch:row){
            if(set.contains(ch)){
                return false;
            }
            else{
                if(ch!='.')
                set.add(ch);
            }
        }
        return true;
    }
    public boolean isValidCol(int col,char[][] board){
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<9;i++){
            if(set.contains(board[i][col])){
                return false;
            }
            else{
                if(board[i][col]!='.'){
                    set.add(board[i][col]);
                }
            }
        }
        return true;
    }
    public boolean isSubGrid(int r,int c,char[][] board){
        HashSet<Character> set=new HashSet<>();
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(board[i][j]!='.'&&set.contains(board[i][j])){
                    return false;
                }
                else{
                    set.add(board[i][j]);
                }
            }
        }
        return true;
    }
}