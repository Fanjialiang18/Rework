package main.Java.ShuZu.Day01;

public class Leetcode27 {
    /**
     * 移除元素，快慢指针法，不改变元素相对位置
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement1(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    /**
     * 相向指针法，改变了元素相对位置，但是移动的元素最少
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            // 找左边等于val的元素
            while (leftIndex <= rightIndex && nums[leftIndex] != val){
                ++leftIndex;
            }
            // 找右边不等于val的元素
            while (leftIndex <= rightIndex && nums[rightIndex] == val) {
                -- rightIndex;
            }
            // 将右边不等于val的元素覆盖左边等于val的元素
            if (leftIndex < rightIndex) {
                nums[leftIndex++] = nums[rightIndex--];
            }
        }
        return leftIndex;   // leftIndex一定指向了最终数组末尾的下一个元素
//        int left = 0;
//        int right = nums.length - 1;
//        while(right >= 0 && nums[right] == val) right--; //将right移到从右数第一个值不为val的位置
//        while(left <= right) {
//            if(nums[left] == val) { //left位置的元素需要移除
//                //将right位置的元素移到left（覆盖），right位置移除
//                nums[left] = nums[right];
//                right--;
//            }
//            left++;
//            while(right >= 0 && nums[right] == val) right--;
//        }
//        return left;
    }
}