class Solution {
    
    int M=(int)1e9+7;
    
    public int countGoodNumbers(long n) {
        
        /*
            odd idx contains prime numbers {2,3,5,7}
            even idx contains even numbers {0,2,4,6,8}
            
            now,
                number of ways to fill odd position = 4
                number of ways to fill even positions = 5
                
                so suppose n=5
                total number of ways to make correct sequence = 5*4*5*4
                ----------------------------------------------= (5*5)*(4*4)
            
        */
        
        long M = (long)1e9+7;
        // return (int)(modPow(5, (n+1)/2, M) * modPow(4, n/2, M) % M);
        return (int)(pow(20 , n/2) * (n % 2 == 0 ? 1 : 5) % M);   // optimized way
    }
    
    
    
    private long pow(long num,long n){
        
        if(n==0)
            return 1;
        
        return (n%2==0)?pow((num*num)%M,n/2)%M : (num*pow((num*num)%M,n/2))%M;
    }
}
