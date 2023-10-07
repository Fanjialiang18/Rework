package main.Java.TanXin;

import java.util.Arrays;
import java.util.LinkedList;

public class LeetCode406 {
    public int[][] reconstructQueue(int[][] people) {
        // 首先按照h从降序排序，h相同的按照k升序排序
        Arrays.sort(people, (o1, o2) -> {
            if(o1[0] == o2[0]){
                // o1-o2是升序
                return o1[1]-o2[1];
            }else {
                // o2-o1是降序
                return o2[0]-o1[0];
            }
        });
        // 排序后按照k的数字决定下标即可，由高到低，指定元素插入后刚好只有前面的比该元素大
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[people.length][]);
    }
}
