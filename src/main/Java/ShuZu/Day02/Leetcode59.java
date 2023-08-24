package main.Java.ShuZu.Day02;

import java.util.Arrays;
import java.util.Collections;

public class Leetcode59 {

    public static void main(String[] args) {
        int[][] result = generateMatrix(3);
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(result[i]));
        }

    }
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        // 循环的次数，循环的次数决定了每次模拟的长度
        int loop = 0;
        // 每次循环的起点，为[start],[start]
        int start = 0;
        // 填充的数字
        int num = 1;
        // 定义行列
        int i, j;
        while (loop++ < n / 2) {
            // 从左往右
            for (j = start; j < n - loop; j++){
                result[start][j] = num++;
            }
            // 从上往下
            for(i = start; i < n -loop; i++){
                result[i][j] = num++;
            }
            // 从右往左
            for (;j>=loop;j--){
                result[i][j] = num++;
            }
            // 从下往上
            for(;i>=loop;i--){
                result[i][j] = num++;
            }
            start++;
        }
        // n为奇数需要在中间填充，因为不满足循环
        if(n%2==1){
            result[start][start] = num;
        }
        return result;
    }
}
