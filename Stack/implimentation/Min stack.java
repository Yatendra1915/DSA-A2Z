class MinStack {

    Stack<Integer> st;
    int min;
    public MinStack() {
        st = new Stack<>();
    }
    
    /*
        we are using encoding and decoding techniques 
        
        // encoding
        when we will push element we will use encoding
        1. so if current element is greater than min or 
           st is empty simply push the element in st;
        
        2. if curr element is less than min then we'll use encoding technique
           temp = curr+curr-min , then push temp in stack and update min= curr;

        // decoding
        we'll use decoding while poping out the elemnts or getting peek elemnt

        1. if curr element is greater than  or equal to min then pop it simply
        2. if curr element is less than min then that means encoding has been done at this element
           so, what is the actual value then? the actual value is min which was there but????????
           before popping the element and simply returning the min we'll have to take care of previous min 
           element so to decode the curr and min to previous min just do simmple maths
           actual value(or curr) is min,and temp was stored at place of actual value so to get prev min 
           do temp(top element which is stored) = 2*(actual value)-min
           that is 2*min(actual val)-st.peek()(temporary value) is our previous min;
    */ 
    public void push(int val) {
        if(st.isEmpty()){
            st.push(val);
            min = val;
        }
        else if(val>=min){
            st.push(val);
        }
        else{
            int temp = val+val-min;
            st.push(temp);
            min = val;
        }
    }
    
    public void pop() {
        
        if(st.peek()<min){
            int temp = 2*min-st.peek();
            min = temp;
        }

        st.pop();
    }
    
    public int top() {
        if(st.peek()<min){
            return min;
        }

        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}
