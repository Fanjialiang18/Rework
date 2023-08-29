package main.Java.HaXi;

import java.util.HashSet;

public class Leetcode349 {
    /**
     * 数组相交
     * 使用HashSet存放数组的元素
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
        return set2.stream().mapToInt(i->i).toArray();
    }
}
