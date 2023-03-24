class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();

        if(root==null)
            return list;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){

            if(root.left!=null){
                root=root.left;
                st.push(root);
            }
            else{

                TreeNode temp = st.pop();
                list.add(temp.val);

                if(temp.right!=null){
                    st.push(temp.right);
                    root = temp.right;
                }

            }

        }

        return list;
    }
}
Console
