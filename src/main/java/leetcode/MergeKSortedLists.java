package leetcode;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        Queue<ListNode> heap = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
        for(ListNode node : lists) {
            if(node != null){
                heap.offer(node);
            }
        }
        ListNode result = new ListNode(0);
        ListNode tail = result;
        while(!heap.isEmpty()) {
            tail.next = heap.poll();
            tail = tail.next;
            if(tail.next != null) heap.offer(tail.next);
            tail.next.next = null;
        }
        return result.next;
    }

    @Test
    public void test(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;

        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        n4.next = n5;
        n5.next = n6;

        ListNode n7 = new ListNode(2);
        ListNode n8 = new ListNode(6);
        n7.next = n8;

        ListNode[] list = new ListNode[]{n1, n4, n7};
        ListNode listNode = mergeKLists(list);
        while(listNode != null){
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }

}
