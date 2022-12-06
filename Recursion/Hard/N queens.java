class Solution {

    List<List<String>> list;

    public List<List<String>> solveNQueens(int n) {
        
        list = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }

        solve(board,n,0);
        
        return list;
    }

    private boolean solve(char[][] board,int N,int col){

        // we are'nt moving row wise down we are moving column wise right remember
        if(col==N){

            List<String> temp = new ArrayList<>();

            for(int idx=0;idx<N;idx++){
                temp.add(String.valueOf(board[idx]));
            }
            list.add(temp);
            return false;
        }

        // checking in each row for current col
        for(int i=0;i<N;i++){

            if(isValid(board,i,col,N)){

                board[i][col]='Q';

                if(solve(board,N,col+1)){
                    return true;
                }
                else{
                    board[i][col]='.';
                }
            }
        }

        return false;
    }

    private boolean isValid(char[][] board,int row,int col,int N){

       for(int i=0;i<N;i++){
           if(board[row][i]!='.') return false;
       }

       for(int i=0;i<N;i++){
           if(board[i][col]!='.') return false;
       }
        int step = 1;
        while(row-step>=0 && col-step>=0){
            
            if(board[row-step][col-step]!='.') return false;

            step++;
        }

        step = 1;

        while(row+step<N && col-step>=0){

            if(board[row+step][col-step]!='.') return false;

            step++;
        }

        return true;
    }


















}
