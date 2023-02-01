class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap =new PriorityQueue<>();
        maxHeap =new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        
        if(maxHeap.size()==0){
            maxHeap.add(num);
            return;
        }

        if(maxHeap.size()>minHeap.size()){
            
            if(maxHeap.peek()>num){
                int temp = maxHeap.poll();
                maxHeap.add(num);
                minHeap.add(temp);
            }
            else{
                minHeap.add(num);
            }
        }
        else{

            if(minHeap.peek()<num){
                int temp = minHeap.poll();
                minHeap.add(num);
                maxHeap.add(temp);
            }
            else{
                maxHeap.add(num);
            }
            
        }
    }
    
    public double findMedian() {
        
        double min=0;
        double max=0;
        
        int minsize=minHeap.size();
        int maxsize = maxHeap.size();
        if(minsize>0)
            min=minHeap.peek();
        if(maxsize>0)
            max=maxHeap.peek();
        
        return (maxsize+minsize)%2==0?(min+max)/2:max;
    }
}
