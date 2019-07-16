package leetcode;

import org.junit.Test;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null) {
            if (slow == fast) return true;
            slow = slow.next;
            if (fast.next == null || fast.next.next == null) return false;
            fast = fast.next.next;
        }
        return false;
    }

    @Test
    public void test1() {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
//        n4.next = n2;
        System.out.println(hasCycle(n1));
    }
}



