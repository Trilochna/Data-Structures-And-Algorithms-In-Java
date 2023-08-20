    public static void postorderTraversal(Node root){
        // base case
    
        if(root == null){
            return;
        }
        
        // CALL LEFT 
        inorderTraversal(root.left);
        // call right
        inorderTraversal(root.right);
        // print Node
        System.out.println(root.data + " ");

    }
