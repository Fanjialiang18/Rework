package main.Java.TanXin;

public class LeetCode860 {
    public boolean lemonadeChange(int[] bills) {
        int tenNums = 0;
        int fiveNums = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fiveNums++;
            } else if (bill == 10) {
                if (fiveNums <= 0) {
                    return false;
                } else {
                    fiveNums--;
                    tenNums++;
                }
            } else {
                if (tenNums > 0) {
                    if (fiveNums > 0) {
                        tenNums--;
                        fiveNums--;
                    } else {
                        return false;
                    }
                } else {
                    if (fiveNums >= 3) {
                        fiveNums -= 3;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
