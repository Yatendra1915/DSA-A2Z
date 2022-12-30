class Stack{
    
    class Node{
        
        Node next;
        int data;
        
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    
    
    Node top;
    int size;
    
    Stack(){
        top = null;
        size = 0;
    }
    
    public void push(int x){
        
        Node element = new Node(x);
        element.next = top;
        top = element;
        size++;
    }
    
    public int pop(){
        
        if(top == null)
            return -1;
        
        int temp = top.data;
        size--;
        top = top.next;
        return temp;
    }

    public int top(){
        if(top==null) return -1;
        
        return top.data;
    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return size==0;
    }
}







