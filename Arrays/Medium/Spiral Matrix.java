class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> list = new ArrayList<>();
        
        int rowStart = 0;
        int rowEnd   = matrix.length-1;
        
        int colStart = 0;
        int colEnd   = matrix[0].length-1;
        
        while(rowStart<=rowEnd && colStart<=colEnd){
            
            
            for(int i=colStart;i<=colEnd;i++){
                
                list.add(matrix[rowStart][i]);
                
            }
            rowStart++;
            
            if(rowStart>rowEnd || colStart>colEnd) break;
            
            for(int i=rowStart;i<=rowEnd;i++){
                list.add(matrix[i][colEnd]);
            }
            
            colEnd--;
            
            if(rowStart>rowEnd || colStart>colEnd) break;
            
            for(int i=colEnd;i>=colStart;i--){
                list.add(matrix[rowEnd][i]);
            }
            
            rowEnd--;
            
            if(rowStart>rowEnd || colStart>colEnd) break;
            
            for(int i=rowEnd;i>=rowStart;i--){
                list.add(matrix[i][colStart]);
            }
            colStart++;
        }
        
        return list;
    }
}
