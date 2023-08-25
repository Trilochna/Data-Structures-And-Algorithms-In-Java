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
    public boolean isValidBST(TreeNode root) {
        // USING RECURSIVE DEPTH FIRST SEARCH
        if(root == null){return true; }
        return valid(root, null, null);
    }

    public boolean valid(TreeNode root, Integer leftBoundary, Integer rightBoundary){
        if(root == null){return true; }
        if((leftBoundary != null && root.val <= leftBoundary) || (rightBoundary != null && root.val >= rightBoundary)){return false; }
        return valid(root.left, leftBoundary, root.val) && valid(root.right, root.val, rightBoundary);
    }
}
