class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();

        for(char ch:s.toCharArray()){

            if(st.isEmpty()){
                st.push(ch);
            }
            else{

                if(st.peek()=='(' && ch==')') st.pop();
                else if(st.peek()=='{' && ch=='}') st.pop();
                else if(st.peek()=='[' && ch==']') st.pop();

                else st.push(ch);
            }
        }

        return st.isEmpty();
    }
}
