package main.Java.LianBiao;

public class Leetcode707 {
    class MyLinkedList {
        /**
         * 节点定义
         */
        class ListNode {
            int val;
            ListNode next;

            public ListNode() {

            }

            public ListNode(int val) {
                this.val = val;
            }
        }

        // 储存元素数目
        int size;

        // 虚拟头结点
        ListNode head;

        public MyLinkedList() {
            this.size = 0;
            this.head = new ListNode(0);
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode cur = head;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(this.size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index > this.size || index < 0) {
                return;
            }
            ListNode tmp = new ListNode(val);
            ListNode pre = this.head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            tmp.next = pre.next;
            pre.next = tmp;
            this.size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            size--;
            if (index == 0) {
                head= head.next;
                return;
            }
            ListNode pre = this.head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            pre.next = pre.next.next;
        }
    }
}
