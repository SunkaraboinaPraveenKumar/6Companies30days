class Solution {
    int result=0;
    public void backtrack(int idx,String s,StringBuilder sb1,StringBuilder sb2){
        if(idx>=s.length()){
            if(isPalindrome(sb1.toString())&&isPalindrome(sb2.toString())){
                result = Math.max(result,(int)sb1.length()*(int)sb2.length());
            }
            return;
        }
        sb1.append(s.charAt(idx));
        backtrack(idx+1,s,sb1,sb2);
        sb1.deleteCharAt(sb1.length()-1);
        sb2.append(s.charAt(idx));
        backtrack(idx+1,s,sb1,sb2);
        sb2.deleteCharAt(sb2.length()-1);
        backtrack(idx+1,s,sb1,sb2);
    }
    public int maxProduct(String s) {
        backtrack(0,s,new StringBuilder(),new StringBuilder());
        return result;
    }
    public boolean isPalindrome(String str){
        int i=0;
        int j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}