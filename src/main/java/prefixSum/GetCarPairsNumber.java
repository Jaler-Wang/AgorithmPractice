package prefixSum;

/**
 * A non-empty zero-indexed array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.
 * <p>
 * Array A contains only 0s and/or 1s:
 * <p>
 * 0 represents a car traveling east,
 * 1 represents a car traveling west.
 * 
 * The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing
 * when P is traveling to the east and Q is traveling to the west.
 * source form: https://codility.com/programmers/lessons/5-prefix_sums/passing_cars/
 */
public class GetCarPairsNumber {
    static int MAXIMAL = 1000000000;
    public static void main(String[] args) {
        int a[] = new int[]{0, 1, 0, 1, 1};
        int numberOneBehindZero = 0;
        int sum = 0;
        for(int i = a.length - 1; i >= 0; i--){
            if(a[i] == 1){
                numberOneBehindZero++;
            }
            else{
               sum += numberOneBehindZero;
                if(sum >= MAXIMAL){
                    sum = -1;
                    break;
                }
            }
        }
        System.out.println("passing car pairs are " + sum);
    }
}
