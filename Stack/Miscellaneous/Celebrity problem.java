class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	
    	Stack<Integer> st = new Stack<>();
    	
      // push every person in stack
    	for(int i=0;i<n;i++){
    	    st.push(i);
    	}
    	
      /* now while size >=2 
          pop 2 element check if 1st knows 2nd -> if yes then push only 2nd(beacuse it could be poprntial celebrity)
                              if 2nd knows 1st then only push 1st person we popped
      */
    	while(st.size()>=2){
    	    
    	    int person1 = st.pop();
    	    int person2 = st.pop();
    	    
    	    if(M[person1][person2]==0){
    	        st.push(person1);
    	    }
    	    else {
    	        st.push(person2);
    	    }
    	    
    	}
    	
      // potential celebrity
    	int celeb = st.pop();
    	
    	// we are conforming if potential celebrity is real celebrity
    	for(int i=0;i<n;i++){
    	    
          // dont check for M[celeb][celeb] block (diagonal element)
    	    if(i!=celeb){
    	        if(M[celeb][i]==1 || M[i][celeb]==0)
    	            return -1;
    	    }
    	}
    	
    	return celeb;
    }
}
