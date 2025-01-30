package Goldman_Sachs_week6;
import java.util.*;
class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp=new long[n+1];
        dp[1]=1;
        long noOfPeopleSharingSecret=0;
        long ans=0;
        long mod=1000000007;
        for(int i=2;i<=n;i++){
            long newPeople=dp[Math.max(0,i-delay)];
            long forgetPeople=dp[Math.max(0,i-forget)];
            noOfPeopleSharingSecret+=(newPeople-forgetPeople+mod)%mod;
            dp[i]=noOfPeopleSharingSecret;
        }
        for(int i=n-forget+1;i<=n;i++){
            ans=(ans+dp[i])%mod;
        }
        return (int)ans;
    }
}
