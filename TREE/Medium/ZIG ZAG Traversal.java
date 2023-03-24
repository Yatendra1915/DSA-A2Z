class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();

        if(root==null)
            return list;

        Stack<TreeNode> st1 =  new Stack<>();
        Stack<TreeNode> st2 =  new Stack<>();

        st1.push(root);

        while(!st1.isEmpty() || !st2.isEmpty()){

            List<Integer> tempList = new ArrayList<>();

            while(!st1.isEmpty()){

                TreeNode temp = st1.pop();
                tempList.add(temp.val);

                if(temp.left!=null){
                    st2.push(temp.left);
                }

                if(temp.right!=null){
                    st2.push(temp.right);
                }

            }

            list.add(tempList);
            tempList=new ArrayList<>();

            while(!st2.isEmpty()){

                TreeNode temp = st2.pop();
                tempList.add(temp.val);

                if(temp.right!=null){
                    st1.push(temp.right);
                }
                
                if(temp.left!=null){
                    st1.push(temp.left);
                }

            }

            if(tempList.size()>0)
                list.add(tempList);
        }

        return list;

    }
}
