package main.Java.ZiFuChuan;

/**
 * 反转字符串的单词，使用o(1)空间的原地解法
 * 1.去空格
 * 2.反转全部字母
 * 3.反转单词
 *
 * @author fanjl-a
 * @date 2023/9/7 19:57
 */
public class LeetCode151 {
    public String reverseWords(String s) {
        // 移除多余空格
        StringBuilder sb = removeSpace(s);
        // 整体反转
        reverseStr(sb, 0, sb.length()-1);
        // 逐个单词反转
        int start = 0;
        int end =1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' '){
                end++;
            }
            reverseStr(sb, start, end-1);
            start = end + 1;
            end = start + 1;
        }
        return sb.toString();
    }

    /**
     * 移除首位和中间的多余空格
     *
     * @param s
     * @return
     */
    public StringBuilder removeSpace(String s){
        StringBuilder sb = new StringBuilder();
        // 去除首尾空格
        int i = 0;
        int j = s.length()-1;
        while (s.charAt(i) == ' '){
            i++;
        }
        while (s.charAt(j) == ' '){
            j --;
        }
        while (i<=j){
            if(s.charAt(i) != ' '){
                sb.append(s.charAt(i));
                i++;
            }else {
                for (int k = i+1; k <= j; k++) {
                    if(s.charAt(k)!=' '){
                        sb.append(' ');
                        i = k;
                        break;
                    }
                }
            }
        }
        return sb;
    }

    /**
     * 反转指定区间字符串
     *
     * @param s
     * @return
     */
    public void reverseStr(StringBuilder sb, int start, int end){
        while (start < end){
            char t = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, t);
            start ++;
            end --;
        }
    }
}
