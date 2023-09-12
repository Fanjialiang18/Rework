package main.Java.ZiFuChuan;

/**
 * @author clearlove3
 * @date 2023/9/11 13:53
 */
public class Offer58 {

    /**
     * 左旋字符串
     *
     * @param s 源字符串
     * @param n 需要左旋的前n个字符
     * @return 结果字符串
     */
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        reverseWords(sb, 0, n-1);
        reverseWords(sb, n, s.length()-1);
        reverseWords(sb, 0, s.length()-1);
        return sb.toString();
    }

    /**
     * 反转start到end的字符
     *
     * @param sb 需要反转的字符串
     * @param start 反转的开始下标
     * @param end 反转的结束下标
     */
    public void reverseWords(StringBuilder sb, int start, int end){
        while (start < end){
            char t = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, t);
            start ++;
            end --;
        }
    }
}
