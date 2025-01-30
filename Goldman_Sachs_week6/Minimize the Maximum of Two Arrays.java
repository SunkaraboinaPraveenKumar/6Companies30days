package Goldman_Sachs_week6;

class Solution {
    public int minimizeSet(int d1, int d2, int c1, int c2) {
        long low=1;
        long high=Long.MAX_VALUE;
        long lcm=lcm(d1,d2);
        long prev_m=-1;
        long ans=-1;
        while(low<=high){
            long m=low+(high-low)/2;
            long v1=m-m/d1;
            long v2=m-m/d2;
            long v3=m-m/lcm;
            if(v1>=c1&&v2>=c2&&v3>=c1+c2){
                ans=m;
                high=m-1;
            }
            else{
                low=m+1;
            }
        }
        return (int)ans;
    }
    public long lcm(long a,long b){
        return (a/gcd(a,b))*b;
    }
    public long gcd(long a,long b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}
