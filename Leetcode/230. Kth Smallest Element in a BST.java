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
    // INORDER TRAVERSAL CAN BE USED
    public int kthSmallest(TreeNode root, int k) {
        // numbers of elements we visited from our tree 
        // once n == k that means we have visited all nodes
        int n = 0;
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;

        while(curr != null || !s.isEmpty()){ // ensure that the loop continues until all nodes are visited
            while(curr != null){
                s.push(curr);
                // keep going left; before this we have to go back to previuos node 
                curr = curr.left;
            }
            curr = s.pop(); // this means we are processing that node
            n++; // update n value
            if(n == k){
                return curr.val;
            }
           // if we didn't find k' 
            curr = curr.right;
        }
        return -1;
    }
}
