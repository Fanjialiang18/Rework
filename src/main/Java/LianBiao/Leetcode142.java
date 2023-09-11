package main.Java.LianBiao;

public class Leetcode142 {
    /**
     * 环形链表2
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow,fast;
        slow = head;
        fast = head;
        while (fast!=null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            // 相遇则找入点
            if(fast == slow){
                while (head != slow){
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
