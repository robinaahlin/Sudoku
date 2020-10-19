public class SudokuSolver {

    private int[][] matrix;

    public SudokuSolver(){

    }

    public void solve(int[][] matrix){
        this.matrix = matrix;
        if(solve(0,0))
            printBoard();
        else
            System.out.println("No solution found!");

    }

    private boolean solve(int row, int col) {

        if (col == 9) {
            col = 0;
            row++;
        }
        if (row == 9) { // Empty cells filled. Solution found. Abort
            return true;
        }

        if (matrix[row][col] == 0) {
            for (int value = 1; value < 10; value++) {
                if (validValue(row, col, value)) {
                    matrix[row][col] = value;
                    if (solve(row, col + 1)) { // Move to next empty cell
                        return true; // Empty cells filled. Solution found. Abort.
                    }
                    matrix[row][col] = 0; // Empties cell
                }
            }
            return false;
        }
        // Move to next empty cell
        return solve(row, col+1);
    }

    private boolean validValue(int row, int col, int value) {
        int r = 0;
        while (r < 9) {
            if (matrix[r][col] == value) {
                return false;
            }
            r++;
        }
        int c = 0;
        while (c < 9) {
            if (matrix[row][c] == value) {
                return false;
            }
            c++;
        }
        return true;
    }

    private void printBoard() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
