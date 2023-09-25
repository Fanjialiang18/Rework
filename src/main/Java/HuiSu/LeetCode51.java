package main.Java.HuiSu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode51 {

    List<List<String>> ans;

    LinkedList<String> path;

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        path = new LinkedList<>();
        boolean[][] map = new boolean[n][n];
        backTrace(map, 0);
        return ans;
    }

    private void backTrace(boolean[][] map, int row) {
        if (row == map.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int j = 0; j < map.length; j++) {
            if (!map[row][j] && judge(map, row, j)) {
                StringBuilder rowMap = new StringBuilder(".".repeat(map.length));
                rowMap.setCharAt(j, 'Q');
                map[row][j] = true;
                path.add(rowMap.toString());
                backTrace(map, row + 1);
                path.removeLast();
                map[row][j] = false;
            }
        }

    }

    private boolean judge(boolean[][] map, int row, int col) {
        // 检查列
        for (int i = 0; i < map.length; i++) {
            if (map[i][col]) {
                return false;
            }
        }
        // 检查对角线
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (Math.abs(i - row) == Math.abs(j - col) && map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
