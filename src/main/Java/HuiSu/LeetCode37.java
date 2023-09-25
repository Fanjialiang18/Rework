package main.Java.HuiSu;

public class LeetCode37 {
    public void solveSudoku(char[][] board) {
        backTrace(board);
    }

    private boolean backTrace(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) {
                    if (judge(board, i, j, k)) {
                        board[i][j] = k;
                        if(backTrace(board)){
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                // 所有数在这格都试过了，说明是死路，直接返回
                return false;
            }
        }
        return true;
    }

    private boolean judge(char[][] board, int row, int col, char num){
        // 检查行和列
        for (int i = 0; i < board.length; i++) {
            if(board[row][i] == num || board[i][col] == num){
                return false;
            }
        }
        // 检查九宫格
        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;
        for (int i = startRow; i < startRow+3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
}
