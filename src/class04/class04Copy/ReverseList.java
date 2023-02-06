package Algorithm.basic.class04.class04Copy;

public class ReverseList {
    // TODO: 逆转链表
    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value = data;
        }
    }

    public static Node reverse(Node head){
        //TODO: 实际上是用从头节点开始拆链表的过程
        Node next = null;
        Node pre  = null;
        while (head!= null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
