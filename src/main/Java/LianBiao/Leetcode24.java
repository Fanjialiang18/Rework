package main.Java.LianBiao;

public class Leetcode24 {
    // 两个两个交换链表
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        // 虚拟头结点
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        // 前驱，当前，后继，后继的后继
        ListNode pre,cur,next,tmp;
        pre = dummyNode;
        cur = head;
        while (cur != null && cur.next != null){
            // 保存2个后继
            next = cur.next;
            tmp = next.next;

            // 1.前驱的后继指向当前的后继
            pre.next = next;
            // 2.后继的后继指向当前
            next.next = cur;
            // 3.当前的后继指向后继的后继
            cur.next = tmp;

            // 移动前驱和当前
            pre =  cur;
            cur = cur.next;
        }
        return dummyNode.next;
    }
}
