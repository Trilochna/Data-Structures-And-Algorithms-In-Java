class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;

        for(int i = 0; i < rows; i++){ // i - number of rows
            for(int j = 0; j < columns; j++){ // j  - number of columns
                if(check(board, word, i, j, rows, columns, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, String word, int i, int j, int rows, int columns, int currCharacter){
        if(currCharacter >= word.length()){
            return true;
        }

        // what if we go out of bound in the entire board
        if(i < 0 || j < 0 || rows <= i || columns <= j || board[i][j] != word.charAt(currCharacter)){
            return false; // if either board is out of bounce of the word character and character at board are !=
        }

        boolean exist = false; // for result of this dfs function

        // now we will run this backtraking function recursively for all the 4 position in order to get the word

        if(word.charAt(currCharacter) == board[i][j]){ // if first letter is equal
            board[i][j] += 100; // to avoid repeated/used letter by addding 100 to it's ASCII value' to mark the character visited already 
            // start cheching all the positions for the next letter whether equal or not
            
            exist = check(board, word, i + 1, j, rows, columns, currCharacter + 1) ||
                    check(board, word, i - 1, j, rows, columns, currCharacter + 1) ||
                    check(board, word, i, j + 1, rows, columns, currCharacter + 1) ||
                    check(board, word, i, j - 1, rows, columns, currCharacter + 1);

            board[i][j] -= 100; // for updating the value back to original
        }
        return exist;
    }
}
