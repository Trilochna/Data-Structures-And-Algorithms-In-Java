public class Main
{
    // represt every single node of the trie
    static class Node{
        Node[] children; // 26
        boolean endOfWord;
        
        public Node(){
            children = new Node[26]; // a to z 
            // initializing Array
            for(int i = 0; i < 26; i++){
                children[i] = null; // because an object us being created of class node so allocating slight memory is imp. otherwise we will get error 
            }
            endOfWord = false; // initializing
        }
    }
    
    static Node root = new Node();
    
	public static void main(String[] args) {
		String words[] = {"the", "a", "there", "their", "any"};
	}
}
