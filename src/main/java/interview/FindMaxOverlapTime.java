package interview;

/**
 * Created by Jaler on 10/30/2016.
 * <p>
 * this is a amazon interview question.
 * There have a two-dimensional array, the first element is each row is the meeting start time
 * the second element is the meeting end time.
 * e.g. times[2][]={{10, 11}, {10, 12}}
 * Give a times array, how to find the time sector who have the most overlap with others
 */

public class FindMaxOverlapTime {

    public static void main(String[] args) {
        double[][] times = initialTimes();
        int[] result = new int[times.length];
        for(int i = 0; i < result.length; i++){
            result[i] = 1;
        }
        for (int i = 0; i < times.length; i++) {
            for (int j = 0; j < i; j++) {
                if (times[i][0] <= times[j][0] && times[i][1] >= times[j][0]
                        || times[i][0] <= times[j][1] && times[i][1] >= times[j][1]) {
                    result[i]++;
                }
            }
        }
        int maxOne = result[0];
        int maxIndex = 0;
        for(int i = 1; i < result.length; i++){
            if(result[i] > maxOne){
                maxOne = result[i];
                maxIndex = i;
            }
        }
        System.out.println("max overlap time is " + times[maxIndex][0] + " to "
                + times[maxIndex][1] + ". It appear " + maxOne + " times");
    }

    private static double[][] initialTimes() {
        double[][] times = new double[7][2];
        times[0][0] = 9;
        times[0][1] = 10;

        times[1][0] = 9;
        times[1][1] = 11;

        times[2][0] = 10;
        times[2][1] = 11;

        times[3][0] = 11;
        times[3][1] = 12;

        times[4][0] = 9;
        times[4][1] = 12;

        times[5][0] = 13;
        times[5][1] = 15;

        times[6][0] = 13;
        times[6][1] = 14;

        return times;
    }
}
