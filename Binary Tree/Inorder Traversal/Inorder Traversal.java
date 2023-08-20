import java.util.Scanner;

class Main {
    
public static class Node{
    int data;
    Node left; 
    Node right;
    
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null; 
    }
}

    // function to build tree
    public static Node buildTree(){
        
        Scanner scn = new Scanner(System.in);

        // we have to pass the data
        
        // firstly provide data of root node
        System.out.println("ENTER THE DATA (Enter -1 to exit): ");
        int data = scn.nextInt();
        // here the constructor will be called and initialize the values

        if(data == -1){
            return null;
        }
        
        Node root = new Node(data);
        
        // fill lefgt node under the root 
        
        // we will use recursion here
        System.out.println("ENTER THE DATA FOR LEFT NODE OF " + data + " : ");

        root.left = buildTree();
        System.out.println("ENTER THE DATA FOR RIGHT NODE "  + data + " : ");

        root.right = buildTree();

        return root;
    }
    
    public static void inorderTraversal(Node root){
        // base case
    
        if(root == null){
            return;
        }
        
        // LNR
        // CALL LEFT 
        inorderTraversal(root.left);
        // print Node
        System.out.println(root.data + " ");
        // call right
        inorderTraversal(root.right);
    }
    
    
    public static void main(String[] args) {

        // creating a tree
       Node root = buildTree();
       
       System.out.println("INORDER TRAVERSAL IS :   ");
       inorderTraversal(root);
       
       // 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1 
       
        
    }
}
