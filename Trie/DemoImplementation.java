class Main {
    public static class TrieNode{
        char data;
        TrieNode[] children = new TrieNode[26];
        boolean isTerminal;
        
        TrieNode(char ch){
            data = ch;
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
            isTerminal  = false;
        }
    }
    
    public static class Trie{
        TrieNode root = new TrieNode(' ');
        
        void insertUtil(TrieNode root, String word){
            if(word.length() == 0){
                root.isTerminal = true;
                return;
            }
            // assuming words is in caps
            int index = word.charAt(0) - 'A';
            TrieNode child;
            // present case
            if(root.children[index] != null){
                child = root.children[index];
            }else{ // absent case
                child = new TrieNode(word.charAt(0));
                root.children[index] = child;
            }
            insertUtil(child, word.substring(1));
        }
        
        void insertWord(String word){
            insertUtil(root, word.toUpperCase());
        }
    }
    
    public static void main(String[] args) {
        Trie t = new Trie(); 
        t.insertWord("Trilochna");
    }
}
