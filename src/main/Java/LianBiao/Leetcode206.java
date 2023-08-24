package main.Java.LianBiao;

public class Leetcode206 {
    /**
     * 翻转链表
     * 1.保存next
     * 2.翻转cur
     * 3.移动cur，pre
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre,cur,next;
        pre = null;
        cur = head;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
