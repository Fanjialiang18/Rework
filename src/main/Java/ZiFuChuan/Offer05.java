package main.Java.ZiFuChuan;

/**
 * 字符串替换
 *
 * @author fanjl-a
 * @date 2023/9/7 17:05
 */
public class Offer05 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' '){
                sb.append(s.charAt(i));
            }else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }
}
