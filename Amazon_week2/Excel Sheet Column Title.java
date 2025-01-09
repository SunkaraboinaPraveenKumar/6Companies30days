class Solution {
    public String convertToTitle(int col) {
        StringBuilder sb=new StringBuilder();
        helper(col,sb);
        return sb.reverse().toString();
    }
    public void helper(int col,StringBuilder sb){
        if(col<=0){
            return;
        }
        col--;
        char ch=(char)(col%26+'A');
        sb.append(ch);
        helper(col/26,sb);
    }
}