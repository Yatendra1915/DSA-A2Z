class Solution {
    public boolean exist(char[][] board, String word) {
        
        int n = board.length;
        int m = board[0].length;
        
        boolean visited[][] = new boolean[n+1][m+1];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                boolean doesExist = helper(board,word,i,j,0,visited);
                
                if(doesExist)
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean helper(char[][] board,String word,int i,int j,int idx,boolean visited[][]){
        
        if(idx==word.length()){
            return true;
        }
        
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || word.charAt(idx)!=board[i][j] || visited[i][j]){
            return false;
        }
        
        
        
        visited[i][j]=true;
        
        boolean res =   helper(board,word,i+1,j,idx+1,visited) 
                     || helper(board,word,i-1,j,idx+1,visited)
                     || helper(board,word,i,j+1,idx+1,visited)
                     || helper(board,word,i,j-1,idx+1,visited);
        
        visited[i][j]=false;
        
        return res;
    }
}
