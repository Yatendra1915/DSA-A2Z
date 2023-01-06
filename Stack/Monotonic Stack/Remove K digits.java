class Solution {
    public String removeKdigits(String num, int k) {
        
        int n = num.length();

        if(k==n)
            return "0";

        Stack<Character> st =  new Stack<>();

        for(int i=0;i<n;i++){
            
            while(!st.isEmpty() && k>0 && st.peek()>num.charAt(i)){
                st.pop();
                k--;
            }

            st.push(num.charAt(i));
        }

        // if digits are in increasing order or all digits are same
        while(k-->0){
            st.pop();
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        sb.reverse();

        //remove all the 0 at the head
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}
