public void quickSort(int[] arr,int low,int high){

    if(low<high){
      
        int p = partition(int arr[],int low,int high);
        
        quickSort(arr,low,p-1);
        quickSort(arr,p+1,high);
    }

}

public int partition(int[] arr,int low,int high){

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
