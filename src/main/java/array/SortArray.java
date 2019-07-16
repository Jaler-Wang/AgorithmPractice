package array;

public class SortArray {
    private int next;
    private int[] data;

    public SortArray(int capacity) {
        this.next = 0;
        data = new int[capacity];
    }

    public void add(int ele) {
        if (next == data.length) {
            System.out.println("array has full, cannot add new element");
            return;
        }
        int index = findLocation(ele, 0, next);
        int last = next;
        while (last > index) {
            data[last--] = data[last];
        }
        data[index] = ele;
        next++;
    }

    public void delete(int ele){
        int index = find(ele, 0, next);
        if(index == -1){
            System.out.println("not exists");
            return;
        }

        while(index < next-1){
            data[index] = data[index + 1];
            index++;
        }
        next--;
    }

    public void update(int oldEle, int newEle){
        delete(oldEle);
        add(newEle);
    }

    private int find(int ele, int start, int end) {
        if(start > end) return -1;
        int mid = (end - start)/2 + start;
        if(data[mid] == ele) return mid;
        if(data[mid] < ele) return find(ele, mid + 1, end);
        return find(ele, start, mid);
    }

    public void output() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < next; i++) {
            sb.append(data[i] + ", ");
        }
        System.out.println(sb.delete(sb.lastIndexOf(","), sb.length()).toString());
    }

    private int findLocation(int ele, int start, int end) {
        if (start >= end) return start;
        int mid = (end - start) / 2 + start;
        if (data[mid] >= ele) {
            return findLocation(ele, start, mid);
        } else {
            return findLocation(ele, mid + 1, end);
        }
    }


}
