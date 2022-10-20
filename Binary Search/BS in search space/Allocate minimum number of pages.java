class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        
        if(M>N)
            return -1;
            
        int min = 0;
        int max = 0;
        
        for(int i:A){
            max+=i;
        }
        
        int res=-1;
        while(min<=max){
            
            int mid = min + (max-min)/2;
            
            if(ifPossible(A,N,M,mid)){
                res = mid;
                max = mid-1;
            }
            else{
                min = mid+1;
            }
        }
        
        return res;
    }
    
    public static boolean ifPossible(int[]A,int N,int M,int pages){
        
        int students = 1;
        int Countpages = 0;
        
        for(int i:A){
            
            if(Countpages+i<=pages){
                Countpages+=i;
            }
            else{
                students++;
                
                /*  a whole book is to be allocated to a student so if our i(curr book pages) are greater than 
                    our defined no. of pages then we can't allocate that book to any student so return false for this case.
                */
                if(students>M || i>pages)
                    return false;
                    
                Countpages = i;
            }
        }
        
        return true;
        
    }
}
