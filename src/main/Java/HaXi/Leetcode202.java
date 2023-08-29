package main.Java.HaXi;

import java.util.HashSet;

public class Leetcode202 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int res = n;
        while (!set.contains(res)){
            set.add(res);
            n = res;
            res = 0;
            while (n!=0){
                int num = n-n/10*10;
                res += num*num;
                n = n/10;
            }
            if (res == 1){
                return true;
            }
        }
        return false;
    }
}
