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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode rightMostElement = null;
            // pop elements from queue
            int qLength = q.size();

            // go through every element in this level
            for(int i = 0; i < qLength; i++){
                TreeNode curr = q.poll();
                // if curr is null we can simply go to next iteration
                if(curr != null){
                    // update rightmost  to that node
                    rightMostElement = curr;
                    q.add(curr.left);
                    q.add(curr.right);
                }

            }
            if(rightMostElement != null){result.add(rightMostElement.val); }
        }
        return result;
    }
}
