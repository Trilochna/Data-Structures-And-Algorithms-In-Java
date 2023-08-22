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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){ // empty trees are equal
            return true;
        }
        // if one of them are not empty
        // if both of them are not empty
        // check if the values of nodes in both the trees are same or not
        if(p == null || q == null || p.val != q.val){
            return false;
        }
        // if root got to be the saame
        // then we'll start recursive call '
        // to check id the cchild nodes are same or not
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) ? true : false; 
    }
}
