package link;

import org.junit.Test;

public class Link {
    private Data head = new Data();
    public void add(Data data){
        data.next = head.next;
        head.next = data;
    }

    public boolean isNull(){
        if(head.next == null) return true;
        return false;
    }
    public void remove(Data data){
        Data current = head;
        while(current.next != null){
            if(current.next.value == data.value){
                current.next = current.next.next;
            }
        }
    }

    public Data reverse(){
        if(head.next == null) return head;
        Data newHead = head.next;
        head.next = null;
        while(newHead != null){
            Data data = newHead;
            newHead = newHead.next;
            add(data);
        }
        return head;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Data current = head.next;
        while(current != null){
            sb.append(current.value).append(" ->");
            current = current.next;
        }
        sb.delete(sb.length() - 3, sb.length());
        return sb.toString();
    }

    public Data findMiddle(){
        if(head.next == null) return null;
        Data slow = head.next;
        Data fast = head.next.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Link mergeLinks(Link l1, Link l2){
        Link result = new Link();
        if(l1.isNull()) return l2;
        if(l2.isNull()) return l1;
        Data head1 = l1.head.next;
        Data head2 = l2.head.next;
        Data head = result.head;
        while(head1 != null || head2 != null){
            if(head1 != null && head2 != null){

                if(head1.value > head2.value){
                    Data data = head1;
                    head1 = head1.next;
                    result.add(data);
                }
                else{
                    Data data = head2;
                    head2 = head2.next;
                    result.add(data);
                }
            }
            else {
                while(head1 != null){
                    Data data = head1;
                    head1 = head1.next;
                    result.add(data);
                }
                while(head2 != null){
                    Data data = head2;
                    head2 = head2.next;
                    result.add(data);
                }
            }
        }
        result.reverse();
        return result;
    }

    @Test
    public void mergeLinkTest(){
        Link l1 = new Link();
        l1.add(new Data(1));
        l1.add(new Data(3));
        l1.add(new Data(5));
        System.out.println(l1);
        Link l2 = new Link();
        l2.add(new Data(2));
        l2.add(new Data(4));
        l2.add(new Data(6));
        System.out.println(l2);
        System.out.println(mergeLinks(l1, l2));
    }

    @Test
    public void reverseLinkTest(){
        Link link = new Link();
        link.add(new Data(1));
        link.add(new Data(2));
        link.add(new Data(3));
        System.out.println(link);
        link.reverse();
        System.out.println(link);
    }

    @Test
    public void findMiddleTest(){
        Link link = new Link();
        link.add(new Data(1));
        link.add(new Data(2));
        link.add(new Data(3));
        link.add(new Data(4));
        link.add(new Data(5));
        Data middle = link.findMiddle();
        if(middle != null){
            System.out.println(middle.value);
        }
    }
}
