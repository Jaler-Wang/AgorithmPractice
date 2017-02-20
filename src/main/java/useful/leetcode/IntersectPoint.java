package useful.leetcode;
import org.junit.Test;
/**
 * Created by U0148394 -Jianle.Wang on 2/13/2017.
 */
public class IntersectPoint {
    @Test
    public void test() {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ln1.next = ln2;
        ListNode headA = ln1;
        ListNode headB = ln2;
        ListNode common = getIntersectionNode(headA, headB);
        System.out.println(common.val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lengthA = 0;
        int lengthB = 0;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != null) {
            lengthA++;
            p1 = p1.next;
        }
        while (p2 != null) {
            lengthB++;
            p2 = p2.next;
        }
        p1 = headA;
        p2 = headB;
        if (lengthA > lengthB) {
            while (lengthA != lengthB) {
                p1 = p1.next;
                lengthA--;
            }
        }
        if (lengthA < lengthB) {
            while (lengthB != lengthA) {
                p2 = p2.next;
                lengthB--;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // if(p1 == null || p2 == null) return null;
        return p1;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
