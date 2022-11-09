class Solution {
    public String frequencySort(String s) {
        
        /*
            Approach
            1. store all characters and their freq in map
            2. then create heap and store characters such that characters having higher freq in map will come first
            3. extract characters from heap and append it in resultant freq times
            4. return resultant string
        */
        Map<Character,Integer> map = new HashMap<>();
        
        for(char ch : s.toCharArray()){
            
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        
        for(char ch:map.keySet()){
            pq.offer(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()){
            
            char ch = pq.poll();
            
            for(int i=0;i<map.get(ch);i++){
                sb.append(ch);
            }
            
        }
        
        
        return sb.toString();
    }
}
