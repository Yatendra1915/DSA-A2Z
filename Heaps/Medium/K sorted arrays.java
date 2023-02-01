class Pair{
    
    int listidx;
    int dataidx;
    int value;
    
    Pair(int listidx,int dataidx,int value){
        this.listidx = listidx;
        this.dataidx = dataidx;
        this.value = value;
    }
}
class Solution
{
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
       
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            
            public int compare(Pair p1,Pair p2){
                
                return p1.value-p2.value;
            }
        });
        
        
        for(int i=0;i<K;i++){
            // (index of list,index of element,element)
            pq.add(new Pair(i,0,arr[i][0]));
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(pq.size()>0){
            
            Pair temp = pq.poll();
            
            ans.add(temp.value);
            temp.dataidx++;
            
            if(temp.dataidx<K){
                temp.value = arr[temp.listidx][temp.dataidx];
                pq.add(temp);
            }
            
            
        }
        
        return ans;
        
    }
}
