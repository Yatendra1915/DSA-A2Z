class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        
    // left
    // right
    // root

        List<Integer> list = new ArrayList<>();

        if(root==null)
            return list;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){

            TreeNode temp = st.pop();
            list.add(temp.val);

            if(temp.left!=null){
                st.push(temp.left);
            }
            if(temp.right!=null){
                st.push(temp.right);
            }

            

        }
        Collections.reverse(list);
        return list;

    }
}
