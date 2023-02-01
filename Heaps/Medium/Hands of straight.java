class Solution {
    public boolean isNStraightHand(int[] nums, int k) {
        HashMap<Integer, Integer> map= new HashMap<>();
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int val: nums){
            map.put(val, map.getOrDefault(val, 0)+1);
            pq.add(val);
        }
        while(!pq.isEmpty()){
            int min= pq.poll();
            map.put(min, map.get(min)-1);
            if(map.get(min)<=0)
                map.remove(min);
            
            for(int i=0; i<k-1; i++){
                if(pq.isEmpty())
                    return false;
                
                if(map.containsKey(min+1)){
                    map.put(min+1, map.get(min+1)-1);
                    if(map.get(min+1)<=0)
                        map.remove(min+1);
                    pq.remove(min+1);
                    min++;
                }
                else return false;
            }
        }
        return true;
    }
}
