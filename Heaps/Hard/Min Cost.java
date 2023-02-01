class Solution
{
   
    long minCost(long arr[], int n) 
    {
        long temp = 0;
        long ans = 0;
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for(long i:arr){
            pq.add(i);
        }
        
        
        while(pq.size()>=2){
            
            long p1 = pq.poll();
            long p2 = pq.poll();
            
            ans+=p1+p2;
            pq.add(p1+p2);
        }
        
        return ans;
    }
}
