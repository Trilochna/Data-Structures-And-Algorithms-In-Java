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
    
    static Node root = new Node(); // because it is a static variable and if get changed once then it will remain changed
    // hence it might get wrong answer if we try to update it regularly
    // so try putting it's variable into a temporary node and then function
    
    
    // till now we have defined trie data structure
    // now we will start storing data in it 
    
    
    //INSERTION IN TRIE 
    public static void insert(String singleWordFromArray){
        Node curr = root;
        for(int i = 0; i < singleWordFromArray.length(); i++){ // TC - O(L)
            int index = singleWordFromArray.charAt(i) - 'a';
            if(curr.children[index] == null){
                // add new Node
                curr.children[index] = new Node();
            }
            if(i == singleWordFromArray.length() - 1){
                curr.children[index].endOfWord = true;
            }
            curr = curr.children[index];
        }
    }
    
    // till now we have created the entire trie 
    
    // SEARCH IN TRIE
    public static boolean search(String key){
        Node curr = root;
        for(int i = 0; i < key.length(); i++){  // TC - O(L)
            int index = key.charAt(i) - 'a';
            
            Node node = curr.children[index];
            
            if(node == null){
                return false;
            }
            
            if(i == key.length() - 1 && node.endOfWord == false){
                return false;
            }
            // update to check level by level and character by character
            curr = curr.children[index];
        }
        return true;
    }
    
	public static void main(String[] args) {
		String words[] = {"the", "a", "there", "their", "any"};
		
		for(int i = 0; i < words.length; i++){
		    insert(words[i]);
		}
		
		System.out.println(search("their"));
		System.out.println(search("thor"));
		System.out.println(search("an"));
	}
}
