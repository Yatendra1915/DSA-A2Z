class solve {
    
    // TC -For each node we have three choices N^3 for m  choices - O(N^M)
    // SC -O(N) -- Depth of the tree -- recursion space
    
 
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // creating colour array for the vertices = 4
        int color[]=new int[n];
        if(solve(graph,0,m,n,color)) return true;
        
        return false;
    }
    
     public boolean solve(boolean graph[][],int node,int m, int v,int color[]){
         
        // Base case
        
        if(node==v){
            
        return true;
        }
        
        // trying all the possible combination of the m
        
        for(int i=1; i<=m;i++){
            
        if(isValid(graph,i,color,node)) {
            color[node]=i;
            
            if(solve(graph,node+1,m,v,color)) {
                return true;
            }
            else {
                color[node]=0;
            }
            
            
        }    
            
        }
        return false;
         
        }
     
     public boolean isValid(boolean graph[][],int col,int color[],int node ){
         
         // take out the respective vertices for the vertex
         
        for(int i=0; i<graph[node].length;i++){
            if(graph[node][i]==true) {
                if(color[i]==col) return false;
            }
        }
         
         return true;
     }
}
