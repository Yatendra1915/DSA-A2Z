class Solution {
    public double myPow(double x, int n) {
        
        if(n==0)
            return 1;
        // edge case
        if(n==Integer.MIN_VALUE){
            x=x*x;
            n=n/2;
        }
      
        if(n<0){
          // n = -n because if we pass simply n then again n wiil be less than 0 and aur 1/x*1/x will beacome x*x(x=/x);
            x=1/x;
            n=-n;
        }
        
        return (n%2==0)?myPow(x*x,n/2):x*myPow(x*x,n/2);
    }
}
