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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {       
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) { return result; }
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        Stack<List<Integer>> stack = new Stack<>();
        while(!qu.isEmpty()){
            int size = qu.size();
            List<Integer> levelNodes = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode temp = qu.poll();
                levelNodes.add(temp.val);
                if(temp.left != null){
                    qu.add(temp.left);
                }
                if(temp.right != null){
                    qu.add(temp.right);
                }
            }
            stack.push(levelNodes);
        }

        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }
}
