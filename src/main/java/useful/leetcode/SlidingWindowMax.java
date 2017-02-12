package useful.leetcode;

import java.util.LinkedList;

/**
 * 239. Sliding Window Maximum
 * Given an array nums, there is a sliding window of size k
 * which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 *
 * We scan the array from 0 to n-1, keep "promising" elements in the deque. The algorithm is amortized O(n) as each element is put and polled once.

 At each i, we keep "promising" elements, which are potentially max number in window [i-(k-1),i] or any subsequent window. This means

 If an element in the deque and it is out of i-(k-1), we discard them. We just need to poll from the head, as we are using a deque and elements are ordered as the sequence in the array

 Now only those elements within [i-(k-1),i] are in the deque. We then discard elements smaller than a[i] from the tail. This is because if a[x] <a[i] and x<i, then a[x] has no chance to be the "max" in [i-(k-1),i], or any other subsequent window: a[i] would always be a better candidate.

 As a result elements in the deque are ordered in both sequence in array and their value. At each step the head of the deque is the max element in [i-(k-1),i]
 */
public class SlidingWindowMax {
    public int[] max(int[] nums, int k){
        if(nums == null || nums.length == 0) return new int[0];
        LinkedList<Integer> window = new LinkedList<Integer>();
        int[] result = new int[nums.length - k + 1];
        int rIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if(!window.isEmpty() && i-k+1 > window.getFirst()){
                window.removeFirst();
            }
            while(!window.isEmpty() && nums[window.getLast()] < nums[i]){
                window.removeLast();
            }
            window.addLast(i);
            if(i >= k - 1){
                result[rIndex++] = nums[window.getFirst()];
            }
        }
        return result;
    }
}
