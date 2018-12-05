package leetcode;

// Definition for singly-linked list.


import org.junit.Test;

public class AddTwoNumber {
    //https://leetcode.com/problems/add-two-numbers/description/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode nextNode = sentinel;
        int sum = 0;
        while(l1 != null || l2 != null){
            sum /= 10;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            nextNode.next = new ListNode(sum % 10);
            nextNode = nextNode.next;
        }

        if (sum / 10 == 1){
            nextNode.next = new ListNode(1);
        }

        return sentinel.next;
    }


}
