package main.Java.LianBiao;

public class Leetcode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        // 求两个链表长度
        while (curA != null){
            curA = curA.next;
            lenA++;
        }
        while (curB != null){
            curB = curB.next;
            lenB++;
        }
        curA = headA;
        curB = headB;
        int lenGap = Math.abs(lenA - lenB);
        // 对齐两个链表的起点
        if (lenA > lenB){
            while (lenGap > 0){
                curA = curA.next;
                lenGap--;
            }

        }else {
            while (lenGap > 0){
                curB = curB.next;
                lenGap--;
            }
        }
        // 一起遍历查看是否相等
        while (curA != curB && curA != null){
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}
