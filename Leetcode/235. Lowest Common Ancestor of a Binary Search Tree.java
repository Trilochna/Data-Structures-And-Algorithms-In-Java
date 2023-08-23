/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while(curr != null){
            // case 1 
            if(p.val > curr.val && q.val > curr.val){
            // if both greater than the current value so we are going in the right subtree
                // update the current pointer
                curr = curr.right;

            }
            // case 2
            else if(p.val < curr.val && q.val < curr.val){
             // if both greater than the current value so we are going in the left subtree
                curr = curr.left;
            } else{ // if the split occurs or we found p or q
                // which means that we found our result
                return curr;
            }
        }
        return curr;
    }
}
