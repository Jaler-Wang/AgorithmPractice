package leetcode;

import org.junit.Test;

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode head1 = head;
        ListNode head2 = head;
        ListNode pre = head;
        while(head2 != null && head2.next != null){
            pre = head1;
            head1 = head1.next;
            head2 = head2.next.next;
        }
        head2 = pre.next;
        pre.next = null;
       head1 = mergeSort(head);
       head2 = mergeSort(head2);
       return merge(head1, head2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        if(head1== null) return head2;
        if(head2 == null) return head1;
        if(head1.val < head2.val){
            head1.next = merge(head1.next, head2);
            return head1;
        }
        else{
            head2.next = merge(head1, head2.next);
            return head2;
        }
    }

    @Test
    public void test(){
        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(2);
        head = sortList(head);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
