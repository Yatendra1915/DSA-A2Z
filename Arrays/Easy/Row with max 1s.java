class Solution {
  
    /*
        Input: 
        N = 4 , M = 4
        Arr[][] = {{0, 1, 1, 1},
                   {0, 0, 1, 1},
                   {1, 1, 1, 1},
                   {0, 0, 0, 0}}
        Output: 2
        Explanation: Row 2 contains 4 1's (0-based indexing).
        
        /*
            APPROACH
            start from top right corner
            if arr[i][j]==1
               move to left corner(j--) and store the rowindex in a variable;
            if arr[i][j]==0
               move to down and continuously move to down position(i++) until 1 is found or while condition becomes false;
        */
    */
    int rowWithMax1s(int arr[][], int n, int m) {
        
        int i=0;
        int j=m-1;
        
        int maxRow=-1;
        
        while(i<n && j>=0){
            
            if(arr[i][j]==1){
                j--;
                maxRow=i;
            }
            else if(arr[i][j]==0){
                i++;
            }
            
        }
        
        return maxRow;
    }
}
