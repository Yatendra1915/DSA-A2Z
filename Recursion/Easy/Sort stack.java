class Main  
{  
  
     // Recursive method to sort a stack  
    public static void sortStack(Stack<Integer> stack)  
    {  
        // base case: stack is empty  
        if (stack.isEmpty()) {  
            return;  
        }  
   
        // remove the top element  
        int top = stack.pop();  
   
        // recur for the remaining elements in the stack  
        sortStack(stack);  
   
        // insert the popped element back into the sorted stack  
        sortedInsert(stack, top);  
    } 
  
  
    // Insert the given key into the sorted stack while maintaining its  
    // sorted order. This is similar to the recursive insertion sort routine.  
    public static void sortedInsert(Stack<Integer> stack, int key)  
    {  
        // base case: if the stack is empty or  
        // the key is greater than all elements in the stack  
        if (stack.isEmpty() || key > stack.peek())  
        {  
            stack.push(key);  
            return;  
        }  
   
        /* We reach here when the key is smaller than the top element */  
   
        // remove the top element  
        int top = stack.pop();  
   
        // recur for the remaining elements in the stack  
        sortedInsert(stack, key);  
   
        // insert the popped element back into the stack  
        stack.push(top);  
    }  
}
