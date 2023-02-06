package class04.class04Copy;

import java.util.Stack;

public class IsPalindromeList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    // TODO:判断一个链表是否是回文串
    public static boolean isPalindrome1(Node head) {
        // TODO:第一种方法是使用完全大小的栈 下面是载入操作
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        // TODO:从头开始逐步进行判断
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome2(Node head) {
        // TODO:折半使用栈的方法 这种方法需要快慢指针
        if (head == null || head.next == null) {
            return true;
        }
        Node right = head.next; // 慢指针 也即是中间起始点
        Node cur = head; // 快指针
        while (cur.next != null && cur.next.next != null) {  // 固定写法
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        // TODO:判断操作
        while (!stack.isEmpty()){
            if (head.value!=stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome3(Node head) {
        //TODO:最后一种不需要空间复杂度的方法
        //TODO: 让两个指针从两头向中间靠齐
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) { // find mid node
            n1 = n1.next; // n1 -> mid
            n2 = n2.next.next; // n2 -> end
        }
        // TODO: 利用一个额外的指针n3逆转右半部分
        n2 = n1.next; // n2 -> right part first node
        n1.next = null; // mid.next -> null
        Node n3 = null;
        while (n2 != null) { // right part convert
            n3 = n2.next; // n3 -> save next node
            n2.next = n1; // next of right node convert
            n1 = n2; // n1 move
            n2 = n3; // n2 move
        }
        n3 = n1; // n3 -> save last node
        n2 = head;// n2 -> left first node
        boolean res = true;
        while (n1 != null && n2 != null) { // check palindrome
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next; // left to mid
            n2 = n2.next; // right to mid
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) { // recover list
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }
}
