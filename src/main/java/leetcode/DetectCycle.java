package leetcode;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while(fast != null && fast != slow){
            slow = slow.next;
            if(fast.next == null) return null;
            fast = fast.next.next;
        }
        if(fast == null) return null;
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
