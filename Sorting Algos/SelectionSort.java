void selectionSort(int arr[], int n)
	{
	    for(int i=0;i<n-1;i++){
	        
	        int min_idx=i;
        
          for(int j=i+1;j<arr.length;j++){
            
            if(arr[min_idx]>arr[j]){
                min_idx=j;
            }
        }
	        
	        int temp = arr[min_idx];
	        arr[min_idx]=arr[i];
	        arr[i]=temp;
	    }
	}
  
