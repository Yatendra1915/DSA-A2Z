class Solution
{
      long floorSqrt(long x){
        
	          if(x==0 || x==1)
	              return x;
	        
		      long low = 0;
		      long high= x;
		
		      long ans = 0;
		
		      while(low<=high){
		    
		          long mid = low + (high-low)/2;
		    
		          if(mid*mid==x)
		              return mid;
		        
		          else if(mid*mid<x){
		              ans = mid;
		        low = mid+1;
		          }
		        
		          else{
		              high = mid-1;
		          }
		    
		    
	      	}
		
	     return ans;
		
	     }
}
