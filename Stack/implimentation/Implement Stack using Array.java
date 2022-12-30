class Stack{

    int top = -1;
    int[] arr = new int[1000];
  
    public void push(int x){
        arr[top++] = x;
    }
  
    public int pop(){
      if(top==-1) return -1;
      
      int temp = arr[top];
      top--;
      return temp;
    } 
  
    public int top(){
      if(top==-1) return -1;
      
      return arr[top];
    }
  
    public int size(){
      return top+1;
    }

}
