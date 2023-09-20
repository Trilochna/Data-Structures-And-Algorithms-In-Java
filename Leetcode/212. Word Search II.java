class Solution {

    public static int rows;
    public static int columns;
    public TrieNode currTrie;

    public List<String> findWords(char[][] board, String[] words) {

        rows = board.length;
        columns = board[0].length;

        TrieNode root = new TrieNode();

        for(String word : words){
            root.addWord(word);
        }

        HashSet<String> result = new HashSet<>();
        HashSet<String> visited = new HashSet<>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                dfsBacktrack(board, "", i, j, root, result, visited, root);
            }
        }
        return new ArrayList<>(result);        
    }

    public void dfsBacktrack(char[][] board, String word, int i, int j, TrieNode node, HashSet<String> result, HashSet<String> visited, TrieNode root){

        // base case
        if(i < 0 || j < 0 || i == rows || j == columns || // board out of bounce
        !node.children.containsKey(board[i][j]) || // in board character not match
        node.children.get(board[i][j]).refs < 1 || // 
        visited.contains(i + "-" + j) // character already used
        ) {return;} // reached base case return function

        visited.add(i + "-" + j); // marking visited
        node = node.children.get(board[i][j]); // updated node value
        word += board[i][j];

        if(node.endOfWord){ // is word found
            node.endOfWord = false; // update endofword value to original
            result.add(word); // add the found word in the result set for output
            root.removeWord(word); // remove the word from root node to empty rootnode for other words
        }


        // checking all dimensions
        dfsBacktrack(board, word, i + 1, j, node, result, visited, root);
        dfsBacktrack(board, word, i - 1, j, node, result, visited, root);
        dfsBacktrack(board, word, i, j + 1, node, result, visited, root);
        dfsBacktrack(board, word, i, j - 1, node, result, visited, root);

        visited.remove(i + "-" + j); // unmark visited to original state for other words
    }

    class TrieNode{
    public HashMap<Character, TrieNode> children; // just to avoid any error at the end otherwise could use array // value in this will be the child node of trie having characters
    public boolean endOfWord;
    public int refs = 0;

    public TrieNode(){
        children = new HashMap<>();
    }

    public void addWord(String word){
        currTrie = this;
        currTrie.refs += 1;

        for(int i = 0; i < word.length(); i++){
            char currCharacter = word.charAt(i);
            if(!currTrie.children.containsKey(currCharacter)){
                currTrie.children.put(currCharacter, new TrieNode());
            }
            currTrie = currTrie.children.get(currCharacter);
            currTrie.refs += 1;
        }
        currTrie.endOfWord = true;
    }

    public void removeWord(String word){
        currTrie = this;
        currTrie.refs -= 1;

        for(int i = 0; i < word.length(); i++){
            char currChar = word.charAt(i);
            if(currTrie.children.containsKey(currChar)){
                currTrie = currTrie.children.get(currChar);
                currTrie.refs -= 1;
            }
        }
    }
}
}
