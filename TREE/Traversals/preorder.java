class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();

        if(root==null)
            return list;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){

            TreeNode temp = st.pop();
            list.add(temp.val);

            if(temp.right!=null){
                st.push(temp.right);
            }

            if(temp.left!=null){
                st.push(temp.left);
            }

        }

        return list;
    }
}
Console
