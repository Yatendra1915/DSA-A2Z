class Pair{

    int num;
    int freq;

    Pair(int num,int freq){
        this.num=num;
        this.freq=freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> map = new HashMap<>();

        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){

            public int compare(Pair p1,Pair p2){
                return p2.freq-p1.freq;
            }
        });

        for(int i:map.keySet()){

            pq.add(new Pair(i,map.get(i)));

        }

        int[] res = new int[k];
        int i=0;
        while(!pq.isEmpty() && k>0){
            
            res[i]=pq.poll().num;
            i++;
            k--;
        }

        return res;
    }
}
