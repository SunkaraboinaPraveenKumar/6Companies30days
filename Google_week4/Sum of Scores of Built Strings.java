class Solution {
    public int[] lpsArray(String str){
        int len=0;
        int i=1;
        int[] lps=new int[str.length()];
        lps[0]=0;
        while(i<str.length()){
            if(str.charAt(i)==str.charAt(len)){
                len++;
                lps[i]=len;
            }
            else{
                if(len!=0){
                    len=lps[len-1];
                }
                else{
                    i++;
                }
            }
        }
        return lps;
    }
    public long sumScores(String s) {
        long score=0L;
        for(int i=s.length()-1;i>=0;i--){
            String sub=s.substring(i);
            score+=(long)commonPrefix(s,sub);
        }
        return score;
    }
    public int commonPrefix(String text,String pat){
        int count=0;
        for(int i=0;i<Math.min(text.length(),pat.length());i++){
            if(text.charAt(i)==pat.charAt(i)){
                count++;
            }
            else{
                break;
            }
        }
        return count;
    }
}