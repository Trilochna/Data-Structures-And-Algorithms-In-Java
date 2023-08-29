/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private int i; // global variable used for deserialize

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // we will be joining all stringgs together at last
        // example = result = ["1", "2"] etc
        List<String> result = new ArrayList<>();
        serializeDFS(root, result);
        // return the result joined by a comma dilemeter
        return String.join(",", result);       
    }

    public void serializeDFS(TreeNode root, List<String> result){
        if(root == null){
            result.add("N");
            return;
        }
        result.add(String.valueOf(root.val)); // type casting node value as string
        serializeDFS(root.left, result);
        serializeDFS(root.right, result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // because we know that the nodes will be separated by commas 
        // so we are going to split the string
        // and we knwo that we will get input in array so we will split it accordingly
        String[] result = data.split(",");
        // pointer i will be used
        return deserializeDFS(result);        
    }

    public TreeNode deserializeDFS(String[] result){
        String rootNode = result[this.i]; // pointing at first position
        if(rootNode.equals("N")){
            this.i++;
            return null;
        }
        // if that root node is not null then we have to build the subtrees
        var node = new TreeNode(Integer.parseInt(rootNode));
        this.i++;
        node.left = deserializeDFS(result);
        node.right = deserializeDFS(result);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
