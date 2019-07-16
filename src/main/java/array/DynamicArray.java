package array;

public class DynamicArray {
    int[] data;
    int capacity = 0;
    int length;
    public DynamicArray(int initCapacity){
        data = new int[initCapacity];
        length = initCapacity;
    }

    public void add(int ele){
        if(capacity == length){
            int[] newArray = new int[length * 2];
            for(int i = 0; i < capacity; i++){
                newArray[i] = data[i];
            }
            newArray[++capacity] = ele;
            length = length*2;
            data = newArray;
        }
        else{
            data[capacity++] = ele;
        }
    }

    public static void main(String[] args){
        DynamicArray dynamicArray = new DynamicArray(10);
        for(int i = 0; i < 25; i++){
            dynamicArray.add(i);
        }
        System.out.println(dynamicArray.length);
        System.out.println(dynamicArray.capacity);

    }

}
