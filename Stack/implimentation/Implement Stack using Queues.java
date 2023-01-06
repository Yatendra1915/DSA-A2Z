class MyStack {

    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);

        int size = queue.size();

        // pop elements from the front of queue and add at the end, this way the element added at last will come 
        // at front and element which was added first will go at last that is LIFO order will be followed
      
        // Node pop and add n-1 elements only
        for(int i=0;i<size-1;i++){
            queue.add(queue.remove());
        }
    }
    
    public int pop() {
        return queue.remove();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.size()==0;
    }
}
