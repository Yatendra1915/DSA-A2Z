class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        
        for(int i=0;i<n;i++){
            // j starts from i beacause we only want to swap elements of upper traingle with lower
            // doing j = 0 will result into same matrix 
            for(int j=i;j<n;j++){
                
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        
        for(int i=0;i<n;i++){
            reverse(matrix,i,n);
        }
        
    }
    
    private void reverse(int[][] matrix,int ROW,int n){
        
        int low =0;
        int high =n-1;
        
        while(low<high){
            
            int temp = matrix[ROW][low];
            matrix[ROW][low]=matrix[ROW][high];
            matrix[ROW][high]=temp;
            
            low++;
            high--;
        }
        
    }
}
