class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet = null;
        Set<Character> colSet = null;

        for(int i =0; i < 9; i++){
            rowSet = new HashSet<>();
            colSet = new HashSet<>();

            for(int j = 0; j < 9; j++){
                char r = board[i][j];
                char c = board[j][i];

                if(r != '.'){
                    if(rowSet.contains(r)){
                        return false;
                    } else {
                        rowSet.add(r);
                    }
                }
            

                if(c != '.'){
                    if(colSet.contains(c)){
                    return false;
                    } else {
                    colSet.add(c);
                    }
                }
            }
        }

        for(int i = 0; i < 9; i= i + 3){
            for(int j = 0; j < 9; j = j + 3){
                if(!checkBlock(i, j, board)){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkBlock(int Indxi, int Indxj, char[][] board){
        Set<Character> blockSet = new HashSet<>();

        int rows = Indxi + 3;
        int cols = Indxj + 3;

        for(int i = Indxi; i < rows; i++){
            for(int j = Indxj; j < cols; j++){
                if(board[i][j] == '.'){
                    continue;
                }

                if(blockSet.contains(board[i][j])){
                    return false;
                }

                blockSet.add(board[i][j]);
            }
        }

        return true;
    }
}
