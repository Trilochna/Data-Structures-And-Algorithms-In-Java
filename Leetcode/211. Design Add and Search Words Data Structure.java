class WordDictionary {

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

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.endOfWord = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word, root, 0);
    }

    public boolean searchHelper(String word, TrieNode curr, int index){
        if(index == word.length()){
            return curr.endOfWord;
        }
            char c = word.charAt(index);
            if(c == '.'){
                for(TrieNode temp : curr.children){
                    if(temp != null && searchHelper(word, temp, index + 1)){
                        return true;
                    }
                }
                return false;
            } else{
                    int idx = c - 'a';
                    if(curr.children[idx] == null){
                        return false;
                }
            return searchHelper(word, curr.children[idx], index + 1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
