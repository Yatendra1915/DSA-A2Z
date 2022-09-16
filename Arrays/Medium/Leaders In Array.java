class Solution{

    static ArrayList<Integer> leaders(int arr[], int n){
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int prev =-1;
        for(int i=n-1;i>=0;i--){
            
            if(arr[i]>=prev){
                prev=arr[i];
                list.add(prev);
            }
        }
        Collections.reverse(list);
        
        return list;
    }
}
