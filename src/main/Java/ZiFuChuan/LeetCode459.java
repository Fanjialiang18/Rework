package main.Java.ZiFuChuan;

/**
 * @author clearlove3
 * @date 2023/9/11 15:34
 */
public class LeetCode459 {
    public boolean repeatedSubstringPattern(String s) {
        String ss = s + s;
        ss = ss.substring(1, ss.length() - 1);
        // java内置的是暴力解法，令人感叹，用KMP试一下
        return contains(ss, s);
    }

    /**
     * 使用KMP进行模式匹配
     *
     * @param s
     * @param need
     * @return
     */
    public boolean contains(String s, String need){
        // 构造next数组
        int[] next = new int[need.length()];
        int j = -1;
        next[0] = j;
        for (int i = 1; i < need.length(); i++) {
            while (j >= 0 && need.charAt(i) != need.charAt(j+1)){
                j = next[j];
            }
            if(need.charAt(i) == need.charAt(j+1)){
                j++;
            }
            next[i] = j;
        }

        // 模式匹配
        int k = -1;
        for (int i = 0; i < s.length(); i++) {
            // 不匹配则回退
            while (k >= 0 && s.charAt(i) != need.charAt(k+1)){
                k = next[k];
            }
            // 相同则后移
            if(s.charAt(i) == need.charAt(k+1)){
                k++;
            }
            // 判断是否匹配完
            if (k == need.length()-1){
                return true;
            }
        }
        return false;
    }
}
