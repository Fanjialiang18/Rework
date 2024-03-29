package main.Java.TanXin;

import java.util.Arrays;

public class LeetCode135 {
    public int candy(int[] ratings) {
        int[] candyNum = new int[ratings.length];
        Arrays.fill(candyNum, 1);
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                candyNum[i + 1] = candyNum[i] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                candyNum[i - 1] = Math.max(candyNum[i - 1], candyNum[i] + 1);
            }
        }
        return Arrays.stream(candyNum).sum();
    }
}
