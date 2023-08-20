    public static void preorderTraversal(Node root){
        // base case
    
        if(root == null){
            return;
        }
        
        // print Node
        System.out.println(root.data + " ");
        // CALL LEFT 
        inorderTraversal(root.left);
        // call right
        inorderTraversal(root.right);
    }
