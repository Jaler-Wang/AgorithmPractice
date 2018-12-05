package sort.basic;

public class BinarySearch {
    public static void main(String[] args){
        int[] data = new int[]{6,1,2,3,4};
        int lastIndex = findLastOne(data);
        System.out.println("the biggest data index is " + lastIndex);
        int val = 4;
        int index = Bs(data, lastIndex, lastIndex + data.length, val);
        System.out.println(index%data.length);
    }

    private static int Bs(int[] data, int low, int high, int val) {
        while(low <= high){
            int mid = low + ((high - low) >> 2);
            if(data[mid%data.length] == val) return mid;
            if(data[mid%data.length] < val){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int findLastOne(int[] data) {
        int element = data[0];
        int low = 0;
        int high = data.length - 1;
        while(low <= high){
            int mid = low + ((high - low) >> 1);
            if(data[mid] >= element){
                if(mid == data.length - 1 || data[mid] > data[mid + 1]){
                    return mid;
                }
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}
