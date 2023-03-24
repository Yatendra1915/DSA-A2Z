class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        List<Integer> list = new ArrayList<>();

        if(root==null)
            return list;

        
        Map<TreeNode,TreeNode> map = new HashMap<>();

        dfs(root,map);

        for(TreeNode t:map.keySet()){
            System.out.println(t.val+"  "+map.get(t).val);
        }
        return findNodeAtKth(target,map,k);

    }

    private List<Integer> findNodeAtKth(TreeNode target,Map<TreeNode,TreeNode> map,int k){

        List<Integer> list = new ArrayList<>();

        if(target==null)
            return list;

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        

        while(!queue.isEmpty()){


            int size = queue.size();
            

            while(size-->0){

                TreeNode temp = queue.poll();
                visited.add(temp);
                
                if(k==0){
                    list.add(temp.val);
                }

                if(temp.left!=null && !visited.contains(temp.left)){
                    queue.add(temp.left);
                }

                if(temp.right!=null &&  !visited.contains(temp.right)){
                    queue.add(temp.right);
                }

                if(map.containsKey(temp) &&  !visited.contains(map.get(temp))){
                    queue.add(map.get(temp));
                }
            }
            k--;
            if(k<0) break;
        }

        return list;

    }

    private void dfs(TreeNode root,Map<TreeNode,TreeNode> map){

        if(root==null){
            return;
        }

        if(root.left!=null){
            map.put(root.left,root);
        }
        if(root.right!=null){
            map.put(root.right,root);
        }

        dfs(root.left,map);
        dfs(root.right,map);

    }
}
