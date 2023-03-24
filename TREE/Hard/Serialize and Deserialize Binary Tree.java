public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return null;
        }

        String leftSide = serialize(root.left);
        String rightSide= serialize(root.right);

        return root.val+","+leftSide+","+rightSide;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data==null)
            return null;

        String tempArray[] = data.split(",");

        Queue<String> queue = new LinkedList<>();
        
        for(String str:tempArray){
            queue.add(str);
        }

        return ConstructTree(queue);

    }

    private TreeNode ConstructTree(Queue<String> queue){

        if(queue.size()==0)
            return null;

        String temp = queue.poll();

        if(temp.equals("null")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(temp));

        root.left = ConstructTree(queue);
        root.right=ConstructTree(queue);

        return root;
    }
}
