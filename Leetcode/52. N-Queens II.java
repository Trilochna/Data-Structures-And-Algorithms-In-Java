class Solution {
    public int totalNQueens(int n) {

        // TC - N^N
        List<List<String>> allBoards = new ArrayList<>(); // list of all possible solution i.e output
        // to avoid complexity instead of creating list of string
        // we will make a 2D character array for ease
        char[][] board = new char[n][n];
        helper(allBoards, board, 0); // function to check a single board 
        return allBoards.size(); // output result
    }

    public void helper(List<List<String>> allBoards, char[][] board, int col){
        // base case
        // if the current board is valid save it and try next configuration
        if(col == board.length){
            saveBoard(allBoards, board); // to save the current board in the allBoards list to send output of all the possible solutions to place queens 
            return;
        }

        // to go to each cell and put or remove queen according to the validity
        for(int row = 0; row < board.length; row++){
            if(isSafe(row, col, board)){ // isSafe helper function to check validity at current point
                board[row][col] = 'Q';
                helper(allBoards, board, col + 1);
                // if the current place of queen for to be wrong after checking further cells
                // remove queen from that position 
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(int row, int col, char[][] board){
        // check all directions 

        // FOR ROW
        for(int x = 0; x < board.length; x++){
            if(board[row][x] == 'Q'){
                return false;
            }

        }


        // FOR COLUMN
        for(int y = 0; y < board.length; y++){
            if(board[y][col] == 'Q'){
                return false;
            }

        }

        // FOR DIAGNOLS

        // upper left (r-1, c-1)
        int r = row; // original position
        for(int c = col; c >= 0 && r >= 0; c--, r--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        // upper right (r-1, c+1)
        r = row;
        for(int c = col; c < board.length && r >=0; c++, r--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        // lower left (r+1, c-1)
        r = row;
        for(int c = col; c >= 0 && r < board.length; r++, c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        // lower right (r+1, c+1)
        r = row;
        for(int c = col; c < board.length && r < board.length; r++, c++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        return true;        
    }

    public void saveBoard(List<List<String>> allBoards, char[][] board){
        String row = "";
        List<String> FinalBoard = new ArrayList<>();

        for(int i = 0; i < board.length; i++){
            row = ""; // empty string
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'Q'){
                    row += 'Q';
                } else{
                    row += '.'; 
                }
            }
            FinalBoard.add(row);
        }

        allBoards.add(FinalBoard);
    }
}












