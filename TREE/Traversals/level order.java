class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> list = new LinkedList<>();

        if(root==null)
            return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        

        while(!queue.isEmpty()){

            int size = queue.size();

            List<Integer> temp = new ArrayList<>();

            while(size-->0){
                TreeNode tempNode = queue.poll();

                temp.add(tempNode.val);

                if(tempNode.left!=null)
                    queue.add(tempNode.left);

                if(tempNode.right!=null)
                    queue.add(tempNode.right);
            }

            list.add(new LinkedList(temp));

        }

        return list;

    }
}
