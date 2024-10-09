package com.wuguowei.test;


public class ListReverse {
    // 定义LinkedList
    static class LinkedListNode {
        int val;
        LinkedListNode next;

        LinkedListNode(int x) {
            this.val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public void setNext(LinkedListNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedListNode a1 = new LinkedListNode(1);
        LinkedListNode a2 = new LinkedListNode(2);
        LinkedListNode a3 = new LinkedListNode(3);
        LinkedListNode a4 = new LinkedListNode(4);
        LinkedListNode a5 = new LinkedListNode(5);
        a1.setNext(a2);
        a2.setNext(a3);
        a3.setNext(a4);
        a4.setNext(a5);

        // 调用反转函数, 函数会执行反转, 并返回反转后的新头结点
        LinkedListNode reversed = reverse(a1);

        // 打印结果
        LinkedListNode cur = reversed;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    // 返回值: 反转后的新头节点
    public static LinkedListNode reverse(LinkedListNode input) {
        // 少于两个, 无需反转, 直接返回
        if(input == null || input.next == null) {
            return input;
        }

        // res保存反转后的新头节点
        LinkedListNode res = input.next;

        LinkedListNode current = input;
        // 这个节点用于保存上一轮替换后的尾节点, 因为下一轮替换时, 要将其指向本轮头节点
        LinkedListNode previous = null;
        while(current != null && current.next != null) {
            // 保存下一轮的头节点
            LinkedListNode nextNode = current.next.next;

            // 反转当前的两个节点
            LinkedListNode second = current.next;
            second.next = current;
            current.next = nextNode;

            // 更新previous
            if(previous != null) {
                // 确保前一对已反转的节点与当前反转的节点连接在一起, 保持链表的完整性
                previous.next = second;
            }
            // 更新previous, 指向当前反转对的尾节点, 为下一次反转做准备
            previous = current;
            current = nextNode;
        }

        return res;
    }
}