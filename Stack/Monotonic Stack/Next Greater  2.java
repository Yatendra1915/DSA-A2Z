class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int n = nums.length;
        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();
        
      // trick is to use the same array 2 times 
        for(int i=2*n-1;i>=0;i--){

            while(!st.isEmpty() && st.peek()<=nums[i%n])
                st.pop();

            if(!st.isEmpty() && st.peek()>nums[i%n]){
                res[i%n]=st.peek();
                st.push(nums[i%n]);
            }
            else{
                st.push(nums[i%n]);
                res[i%n]=-1;
            }
        }

        return res;
    }
}
