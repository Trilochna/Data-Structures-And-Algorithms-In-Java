/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }
        
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()){
            int listSize = qu.size();
            List<Integer> LevelNode = new ArrayList<>();
            for(int i = 0; i < listSize; i++){
                TreeNode temp = qu.poll();
                LevelNode.add(temp.val);        

                if(temp.left != null){
                    qu.add(temp.left);
                } 
                if(temp.right != null){
                    qu.add(temp.right);
                }
            }
            result.add(LevelNode);
        }
        return result;
    }
}



