class Solution {
    int remove_duplicate(int A[],int N){

        int size=0;
        int prev=0;
        for(int i=0;i<N;i++){
            
            if(prev==0||prev!=A[i]){
                
                A[size]=A[i];
                size++;
                prev=A[i];
            }
            
        }
        
        return size;
    }
}
