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
    public TreeNode invertTree(TreeNode root) {
        
        // base case
        if(root == null){
            return null;
        }

        // swap the children 
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

// inverted both the subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
