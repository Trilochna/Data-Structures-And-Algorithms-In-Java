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
    
    
    // till now we have defined trie data structure
    // now we will start storing data in it 
    
    
    //INSERTION IN TRIE 
    public static void insert(String singleWordFromArray){
        for(int i = 0; i < singleWordFromArray.length(); i++){
            int index = singleWordFromArray.charAt(i) - 'a';
            if(root.children[index] == null){
                // add new Node
                root.children[index] = new Node();
            }
            if(i == singleWordFromArray.length() - 1){
                root.children[index].endOfWord = true;
            }
            root = root.children[index];
        }
    }
    
	public static void main(String[] args) {
		String words[] = {"the", "a", "there", "their", "any"};
		
		for(int i = 0; i < words.length; i++){
		    insert(words[i]);
		}
	}
}
