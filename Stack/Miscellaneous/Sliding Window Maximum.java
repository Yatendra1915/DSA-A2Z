class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        // store the elements in increasing order wrt 0th idx element
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int a[],int b[]){
                return b[0]-a[0];
            }
        });
        
        // enter first k values in pq
        for(int i=0;i<k;i++){
            pq.add(new int[]{nums[i],i});
        }
        
        // resultant array
        int ans[] = new int[nums.length-k+1];
      
        // greatest element of 1st window of size k
        ans[0]=pq.peek()[0];
        
        int index=1;
        int curr=k;
        
        while(curr<nums.length){
            
            // if the greatest element is from outside the window pop it simply from pq
            while(!pq.isEmpty() && (pq.peek()[1]<curr-k+1)){
                pq.remove();
            }
            
            // add current element in pq
            pq.add(new int[]{nums[curr],curr});
          
            // store greatest elemnt in k size window
            ans[index++]=pq.peek()[0];
            curr++;
        }
            
        return ans;
    }
}
