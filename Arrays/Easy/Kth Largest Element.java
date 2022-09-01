public int find_Kth_Largest(int[] arr,int k,int low ,int high){
  
  
      if(low<=high){
        int p = partiton(arr,low,high);
        
        if(p<k){
            return find_Kth_Largest(arr,p+1,high);
        }
        
        else if(p>k){
            return find_Kth_Largest(arr,low,p-1);
        }
        
        else{
            
            return arr[p];
        }
      
      }
}

public int partiton(int arr,int low,int high){

    int i=low;
    int j=low;
  
    int pivot = arr[high];
  
    while(i<=high){
        
        if(arr[i]<=pivot){
          
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
          
            i++;j++;
        }
        else{
            i++;
        }
    
    }
  
    return j-1;

}
