class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
      /*
          as our array is row wise and column wise sorted so we can consider this 2d array as 1d array
          and apply binary search on this array because the resultant 1d array will also be sorted.
      */
        int m = matrix.length;
        int n = matrix[0].length;
        
        int low=0;
        int high=m*n-1;
        
        while(low<=high){
            
            int mid = (high-low)/2 + low;
            
          /*
              our 1d array is formed by appending successive rows in array so to know the 
              column index find mid%(number of columns).
              and to know about the row find mid/(number of columns);
          */
            int i = mid/n;
            int j = mid%n;
            
            if(matrix[i][j]==target)
                return true;
            else if(matrix[i][j]<target)
                low=mid+1;
            else
                high=mid-1;
            
        }
        
        return false;
    }
    
}
