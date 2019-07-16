package link;

public class DeLink {
    private Data head;
    private Data tail;
    public void DeLink(){
        head = new Data();
        tail = head;
    }
    public void add(Data data){
        tail.next = data;
        data.previous = tail;
        tail = data;
    }

    public void remove(Data data){
        if(tail == head) return;
        Data current = head.next;
        while(current != null){
            if(current.value == data.value){
                current.previous.next = current.next;
                if(current.next != null){
                    current.next.previous = current.previous;
                }
                break;
            }
            current = current.next;
        }
    }

}
