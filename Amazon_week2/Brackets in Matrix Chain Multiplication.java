class Solution {
    static class Pair<String,Integer>{
        String first;
        int second;
        public Pair(String first, int second){
            this.first=first;
            this.second=second;
        }
    }
    public static Pair<String,Integer> calc(int[] p,Pair<String,Integer>[][] dp, int i,int j){
        if(i==j){
            String st="";
            st+=(char)('A'+i-1);
            return new Pair(st,0);
        }
        if(dp[i][j]!=null&&dp[i][j].second!=-1){
            return dp[i][j];
        }
        int max=Integer.MAX_VALUE;
        String sr="";
        for(int k=i;k<j;k++){
            Pair<String,Integer> pr1=calc(p,dp,i,k);
            Pair<String,Integer> pr2=calc(p,dp,k+1,j);
            int x=pr1.second+pr2.second+p[i-1]*p[k]*p[j];
            String s="("+pr1.first+pr2.first+")";
            if(max>x){
                max=x;
                sr=s;
            }
        }
        dp[i][j]=new Pair(sr,max);
        return dp[i][j];
    }
    static String matrixChainOrder(int arr[]) {
        // code here
        int n=arr.length;
        Pair<String,Integer> dp[][]=new Pair[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=new Pair("",-1);
            }
        }
        Pair<String,Integer> pr=calc(arr,dp,1,n-1);
        return pr.first;
    }
}