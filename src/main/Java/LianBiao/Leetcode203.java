package main.Java.LianBiao;

public class Leetcode203 {
    /**
     * 移除链表元素，使用首节点即可
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
        // 虚拟头节点
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        // 循环遍历
        while (cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
