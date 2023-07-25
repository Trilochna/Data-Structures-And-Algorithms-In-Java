import java.util.* ;
import java.io.*; 
public class Solution {

	public static boolean isSafe(int row, int col, int[][] board, int val){
		// this function will verify all the rule of sudoku

		for(int i = 0; i < 9; i++){
		// rule1 : check row
			if (board[row][i] == val){
				return false;
			}
		// rule2 : check column

			if(board[i][col] == val){
				return false;
			}
		// rule1 : check single 3 X 3 matrix

			if(board[3*(row/3) + i/3][3*(col/3) + i%3] == val){
				return false;
			}

		}

		// because all rule are verified
		// and all conditions satisfy
		return true;

	}

	public static boolean solve(int[][] board){

		for(int row = 0; row < 9; row++){
			for(int col = 0; col < 9; col++){

				// check if cell is empty
				if(board[row][col] == 0){
					// if yes then we can try new values which will be valid to put in that cell
					// trying new values
					for(int val = 1; val <= 9; val++){
						if(isSafe(row, col, board, val)){
							board[row][col] = val;

							// recursive call
							boolean furtherSolutionPossible = solve(board);

							if(furtherSolutionPossible == true){
								return true;
							} else {
							// if further solution is not possible then start backtracking 
								// backtrack to initial start trying vlaues again

								board[row][col] = 0;


							}
						}
					}

					// if we tried all the value but failed to find the solution then 
					return false; // because bnow solution is not possible which is proved till now



				}
			}
		}

		// if it reached till here because the function completed work successfully
		return true;
		

	}
    
	public static void solveSudoku(int[][] sudoku) {
        // Write your code here.

		solve(sudoku); // return result

        
	}
}
