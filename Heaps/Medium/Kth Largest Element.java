class Solution {
    public int findKthLargest(int[] nums, int k) {
        
      /*
        create min heap and initialise pq with first k elelemts;
        now while adding next n-k elements in pq if element at top of pq is less
        than curr elemnt the pop is and add the curr element
        now return peek as kth largest at last
        
      */
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }

        for(int i=k;i<nums.length;i++){
            
            if(pq.peek()<nums[i]){
                pq.poll();
                pq.add(nums[i]);
            }
        }

        return pq.peek();
    }
}
