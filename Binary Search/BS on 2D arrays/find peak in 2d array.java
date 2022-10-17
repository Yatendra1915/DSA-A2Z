class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        
        int low = 0;
        int high=m-1;
        
        while(low<=high){
            
            int mid = (low+high)/2;
            
            int maxColIdx = findMaxElement(mat[mid]);
            
            int maxEle = mat[mid][maxColIdx];
            
            boolean validTop = mid==0?true:mat[mid-1][maxColIdx]<mat[mid][maxColIdx];
            boolean validBottom = mid==m-1?true:mat[mid+1][maxColIdx]<mat[mid][maxColIdx];
            
            if(validTop && validBottom)
                return new int[]{mid,maxColIdx};
            
            else if(validTop){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        
        return new int[]{-1,-1};
    }
    
    public int findMaxElement(int nums[]){
        
        int idx=-1;
        int element=-1;
        
        for(int i=0;i<nums.length;i++){
            
            if(nums[i]>element){
                element=nums[i];
                idx=i;
            }
        }
        
        return idx;
    }
}
