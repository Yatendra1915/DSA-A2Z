class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        HashMap<Character,Integer> hm = new HashMap<>();

        for(char c:tasks){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(hm.values());

        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();

        int time = 0;
        
        while(!pq.isEmpty() || !queue.isEmpty()){

            time++;

            if(!pq.isEmpty()){
                int temp = pq.poll()-1;

                if(temp!=0){
                    queue.add(new Pair(temp,time+n));
                }
            }

            if(!queue.isEmpty() && queue.peek().getValue()==time){
                pq.add(queue.poll().getKey());
                
            }

        }

        return time;

    }
}
