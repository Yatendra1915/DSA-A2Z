class Solution
{
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {        
        ArrayList<Integer> arr = new ArrayList<>();
        
        int i=0;
        int j=0;
        
        /*
            we'll use the same approach as merge two sorted arrays with little changes
            
            use same code as merge two sorted arrays only change we have to do is
            1. if we got arr1[i]==arr2[j] then add only one element
            2. while adding elements in list check if the same element is present at end of the list to avoid duplicacy.
            
        */
        while(i<arr1.length && j<arr2.length){
            
            if(arr1[i]<arr2[j]){
                
                if(arr.size()==0 || arr.get(arr.size()-1) !=arr1[i])
                    arr.add(arr1[i]);
                i++;
            }
            else if(arr1[i]>arr2[j]){
                if(arr.size()==0 || arr.get(arr.size()-1) !=arr2[j])
                    arr.add(arr2[j]);
                j++;
            }
            else{
                if(arr.size()==0 || arr.get(arr.size()-1) !=arr1[i])
                    arr.add(arr1[i]);
                i++;
                j++;
            }
            
        }
        
        while(i<arr1.length){
            if(arr.size()==0 || arr.get(arr.size()-1) !=arr1[i])
                arr.add(arr1[i]);
            i++;
        }
        
        while(j<arr2.length){
            if(arr.size()==0 || arr.get(arr.size()-1) !=arr2[j])
                arr.add(arr2[j]);
            j++;
        }
        
        return arr;
    }
}
