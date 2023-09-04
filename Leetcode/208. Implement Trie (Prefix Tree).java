class Trie {

    class TrieNode{

        public TrieNode[] children;
        public boolean endOfWord;

        public TrieNode(){
            children = new TrieNode[26];
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
            endOfWord = false;
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
        // now we have a empty tree
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            if(i == word.length() - 1){
                curr.children[index].endOfWord = true;
            }
            curr = curr.children[index];
        }
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null){
                return false;
            }
            if(i == word.length() - 1 && curr.children[index].endOfWord == false){
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(curr.children[index] == null){
                return false;
            }
            curr = curr.children[index];           
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
