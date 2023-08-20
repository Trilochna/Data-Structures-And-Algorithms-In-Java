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
    public int maxDepth(TreeNode root) {
        if(root == null){ return 0; }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

// // By Recursive Depth First Search ===================
//         // base case
//         if(root == null){
//             return 0;
//         }
//      // calling recursion
//         return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
/// ============================


//////////==========================================

       // BREADTH FIRST SEARCH
        // i.e. LEVEL ORDER TRAVERSAL

        // // base case
        // if(root == null){ return 0;}

        // // maintain the current level we are at
        // int level = 0;

        // // initialize a deque with only root
        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root);

        // while(!q.isEmpty()){
        //     int levelSize = q.size();
        //     // now we want to go through the queue 
        //     // and remove every element that's currently in it
        //     for(int i = 0 ; i < levelSize; i++){
        //         // pop a node
        //         // add it's children in the queue
        //         //'
        //         TreeNode temp = q.poll();
        //         if(temp.left != null){
        //             q.add(temp.left);
        //         }
        //         if(temp.right != null){
        //             q.add(temp.right);
        //         }
        //     }
        //     // after traversing through entire queue 
        //     // and pushing and poping all the nodes at that particular level 
        //     // we will increase the count of the level
        //     level++;
        // }
        // return level;
//////=======================================================


/// =================================
        // // Depth first search without using recursion 
        // // ITERATIVE DEPTH FIRST SEARCH

        // if(root == null){
        //     return 0;
        // }

        // Stack<TreeNode> nodeStack = new Stack<>();
        // Stack<Integer> depthValue = new Stack<>();

        // nodeStack.push(root);
        // depthValue.push(1);

        // int result = 1;

        // while(!nodeStack.isEmpty()){
        //     TreeNode tempNode = nodeStack.pop();
        //     int temp = depthValue.pop();
        //     result = Math.max(result, temp);
        //     if(tempNode.left != null){
        //         nodeStack.push(tempNode.left);
        //         depthValue.push(temp + 1);                
        //     }
        //     if(tempNode.right != null){
        //         nodeStack.push(tempNode.right);
        //         depthValue.push(temp + 1);                
        //     }
        // }
        // return result;

///=============================================
