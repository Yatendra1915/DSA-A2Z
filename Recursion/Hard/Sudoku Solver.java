class Solution {
    public void solveSudoku(char[][] board) {
        
        solve(board,0,0);
    }
    
    private boolean solve(char[][] board,int i,int j){
        
        // that means 10 th row in 9x9 board
        if(i==9)
            return true;
        
        // if col is 9 its time to move in next row downwards
        if(j==9){
            return solve(board,i+1,0);
        }
        
        // if position is empty
        if(board[i][j]=='.'){
            
            // check which number can we fill from 1 to 9
            for(char c = '1';c<='9';c++){
            
                if(isValid(board,i,j,c)){
                    
                    board[i][j]=c;
                    
                    if(solve(board,i,j+1)){
                        return true;
                    }
                    else{
                        board[i][j]='.';
                    }
                }    
            }            
        }
        // else simply move to next col
        else{
            
            return solve(board,i,j+1);
            
        }
        
        return false;
    }
    
    private boolean isValid(char[][] board,int i,int j,char c){
                
        return isRowValid(board,i,c) && isColValid(board,j,c) && validGrid(board,i,j,c); 
                
    }
    
    public boolean validGrid(char[][] board , int currentRow, int currentCol, char currentVal)
    {
        int x= 3*(currentRow/3);
        int y= 3*(currentCol/3);
        
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[x+i][y+j]==currentVal)
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isRowValid(char[][] board ,int currentRow, char currentVal)
    {
        //checking for currentRow in range 9
        for(int i=0;i<9;i++)
        {
            if( board[currentRow][i] == currentVal)
            {
                return false;
            }
        }
        return true;
    }
     public boolean isColValid(char[][] board ,int currentCol, char currentVal)
    {
        //checking for currentRow in range 9
        for(int i=0;i<9;i++)
        {
            if( board[i][currentCol] == currentVal)
            {
                return false;
            }
        }
        return true;
    }
    
    
}
