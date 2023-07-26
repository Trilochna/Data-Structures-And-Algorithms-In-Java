class Solution {
    public void solveSudoku(char[][] board) {
       helper(board); 
    }
    
    public boolean  helper(char [][]board){
        
        for(int i =0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='.'){//if the board would be empty then only we will be able to fill it 
                    for(char ch='1';ch<='9';ch++){
                        if(IsValid(board,i,j,ch)){
                            board[i][j]=ch;
                            if(helper(board)==true){
                                return true;
                            }
                             else{
                            board[i][j]='.';//if false comes then remove the no empty as backtrack hote waqt uss number ko waha se hatana hoga 
                        }
                        }
                       
                    }
                    
                    return false;//i.e none of the number can be filled from 1 to 9 in that particular spot so return false;
                    
                    
                }
            }
        }
        
        return true;//if every thing is filled so no more '.' would be present in the array
    }
    
    public boolean IsValid(char [][]board,int row,int col,char ch){
        for(int i =0;i<9;i++){
            
            if(board[row][i]==ch){
                return false;
            }
            if(board[i][col]==ch){
                return false;
            }
            
            if(board[3*(row/3) + (i/3)][3*(col/3) + (i%3)]==ch){
                return false;
            }
        }
        
        return true;
    }
}

// class Solution {

//     public boolean isSafe(char[][] board, int row, int col, int val){
//         for(int i = 0; i < 9; i++){
//             if(board[i][col] == (char)(val + '0')){
//                 return false;
//             }
//             if(board[row][i] == (char)(val + '0')){
//                 return false;
//             }
//         }

//             int sRow = (row/3) * 3;
//             int sCol = (col/3) * 3;

//             for(int i = sRow; i < sRow + 3; i++){
//                 for(int j = sCol; j < sCol + 3; j++){
//                     if(board[i][j] == (char)(val+'0')){
//                         return false;
//                     }
//                 }
//             }

//         return true;
//     }

//     public boolean helper(char[][] board, int row, int col){

//         if(row == board.length){
//             return true;
//         }

//         int newRow = 0;
//         int newCol = 0;

//         if(col != board.length - 1){
//             newRow = row;
//             newCol = col + 1;
//         } else {
//             newRow = newRow + 1;
//             newCol = 0;
//         }

//         if(board[row][col] != '.'){
//             if(helper(board, newRow, newCol)){
//                 return true;
//             }
//         } else {
//             for(int i = 1; i <= 9; i++){
//                 if(isSafe(board, row, col, i)){
//                     board[row][col] = (char)(i+'0');
//                     if(helper(board, newRow, newCol)){
//                         return true;
//                     } else {
//                         board[row][col] = '.';
//                     }
//                 }
//             }
//         }
//         return false;
//     }

//     public void solveSudoku(char[][] board) {
//         helper(board, 0, 0);
//     }
// }


// // class Solution {

// //     public static boolean isSafe(int row, int col, char[][] board, char val){

// //         for(int i = 0; i < 9; i++){

// //             if(board[row][i] == val){
// //                 return false;
// //             }
// //             if(board[i][col] == val){
// //                 return false;
// //             }
// //             if(board[3*(row/3) + i/3][3*(col/3) + i % 3] == val){
// //                 return false;
// //             }
// //         }
// //         return true;
// //     }

// //     public static boolean solve(char[][] board){

// //         for(int row = 0; row < 9; row++){
// //             for(int col = 0; col < 9; col++){
// //                 if(board[row][col] == '.'){
// //                     for(char val = 1; val <= 9; val++){
// //                         if(isSafe(row, col, board, val)){
// //                             board[row][col] = val;
                        

// //                         boolean furtherSolutionPossible = solve(board);

// //                         if(furtherSolutionPossible == true){
// //                             return true;
// //                         } else {
// //                             board[row][col] = '.';
// //                         }
// //                     }
// //                     }
                
// //                 return false;
// //                 }
// //             }
// //         }
// //         return true;
// //     }




// //     public void solveSudoku(char[][] board) {
// //         solve(board);
// //     }
// // }
