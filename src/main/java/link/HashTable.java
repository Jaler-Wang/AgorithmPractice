package link;

public class HashTable {
    private Data[] hashTable;
    private int size;

    public HashTable(int size) {
        this.size = (size <= 0) ? 1 : size;
        hashTable = new Data[size];
        for (int i = 0; i < size; i++) {
            hashTable[i] = new Data();
        }
    }

    public void add(int value) {
        int index = Math.abs(value) % size;
        Data data = hashTable[index].next;
        while (data != null) {
            if(data.value == value) return;
        }
        Data newData = new Data(value);
        newData.next = hashTable[index].next;
        hashTable[index].next = newData;
    }

    public boolean get(int value) {
        int index = Math.abs(value) % size;
        Data data = hashTable[index].next;
        while (data != null) {
            if(data.value == value) return true;
        }
        return false;
    }
}
