class MyQueue {

    int front, rear,maxSize,size;
	int arr[];

    MyQueue(int size)
	{
		front=0;
		rear=0;
        maxSize=size;
        this.size=0;
        arr=new int[maxSize];
	}
	
	void push(int x)
	{
        if(size==maxSize) System.out.println("Queue is full.."); return -1;
	    
        int rear = (rear)%100005;
	    size++;
	    arr[rear++]= x;
	} 

    //Function to pop an element from queue and return that element.
	int pop()
	{
		// Your code here
		
		if(front==rear) System.out.println("Queue is Empty..."); return -1;
		
		int front = (front)%100005;
		
		int temp = arr[front];
		
		front++;
		size--;
		return temp;
	} 
    
    int size(){
        return size;
    }
    
    boolean isEmpty(){
        return size==0;
    }
    int top(){
        if(rear==front) System.out.println("Queue is empty..."); return -1;
        
        return arr[front];
    }
}
