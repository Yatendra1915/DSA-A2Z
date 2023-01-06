class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length;
        int n2 = nums2.length;

        int ans[] = nextGreater(nums2);

        int arr[] = new int[n1];
        int idx=0;

        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(nums1[i]==nums2[j]){
                    arr[idx]=ans[j];
                    idx++;
                }
            }
        }

        return arr;
    }

    public int[] nextGreater(int[] nums){

        Stack<Integer> st = new Stack<>();

        int ans[] = new int[nums.length];

        for(int i=nums.length-1;i>=0;i--){

            while(!st.isEmpty() && st.peek()<=nums[i])
                st.pop();

            if(!st.isEmpty() && st.peek()>nums[i]){
                ans[i]=st.peek();
                st.push(nums[i]);
            }
            else{
                st.push(nums[i]);
                ans[i]=-1;
            }
        }

        return ans;
    }
}
