public void mergeSort(int arr[],int low,int high){
  
    if(low==high)
      return;
  
      if(low<high){
          
          int mid = low + (high-low)/2;
        
          mergeSort(arr,low,mid);
          mergeSort(arr,mid+1,high);
        
          merge(arr,low,mid,high);
      }

}

public void merge(int[] arr,int low,int mid,int high){

    int[] ls = new int[mid-low+1]
    int[] rs = new int[high-mid];

    for(int i=0;i<ls.length;i++){
        ls[i]=arr[i+low];
    }
  
    for(int i=0;i<rs.length;i++){
        rs[i]=arr[mid+i];
    }
    
    int i = 0;
    int j = 0;
  
    while(i<ls.length && j<rs.length){
             
             if(ls[i]<rs[j]){
                 arr[l+k]=ls[i++];
             }
             else{
                 arr[l+k]=rs[j++];
             }
             
             k++;
             
         }
         
         while(i<ls.length){
             arr[l+k]=ls[i++];
             k++;
         }
         
         while(j<rs.length){
             arr[l+k]=rs[j++];
             k++;
         }

}
