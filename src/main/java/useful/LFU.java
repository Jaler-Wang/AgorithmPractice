package useful;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * analyse the question:
 *  1>for read: a, if you want to get the result in O(1) time, then you need to use a hashMap;
 *                     (using map to save key, value pair)
 *              b, you need to update the use frequency for this key;
                       (using map to save 'key, count' pair)
 *  2>for put:  a, if the capacity not full, insert directly
 *              b, if capacity is full, then remove the lease used one, and insert the new one.
 *                 i> we need find the least used count key, then remove it and add the new one
 */
public class LFU {
    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;
//    HashMap<>
    public void test(){
        Set<Integer> set = new LinkedHashSet<Integer>();
    }
}

