class Solution {
    public int[][] merge(int[][] intervals) {
        
        ArrayList<int[]> arr = new ArrayList<>();
        
        Arrays.sort(intervals,new Comparator<int[]>(){
            
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });
        
        int low = intervals[0][0];
        int high= intervals[0][1];
        
        for(int i=1;i<intervals.length;i++){
            
            if(intervals[i][0]<=high){
                high=Math.max(high,intervals[i][1]);
            }
            else{
                
                arr.add(new int[]{low,high});
                low=intervals[i][0];
                high=intervals[i][1];
            }
        }
        
        arr.add(new int[]{low,high});
        
        int res[][] = new int[arr.size()][2];
        
        int i =0;
        for(int[] temp : arr){
            res[i++]=temp;
        }
        
        return res;
    }
}
