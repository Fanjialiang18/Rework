package main.Java.LianBiao;

public class Leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;
        // 快指针移动到和慢指针距离为n的位置
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 一起遍历到最后一个节点
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        // 此时慢指针指向倒数第n+1个节点
        slow.next = slow.next.next;
        return dummyNode.next;
    }
}
