import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HorseRace {
    private HashMap<String, Double> qHorseTime;
    private HashMap<String, Double> tHorseTime;
    private ArrayList<String> qHorse;
    public HorseRace(){
        qHorseTime = new HashMap<String, Double>();
        tHorseTime = new HashMap<String, Double>();
        qHorseTime.put("q1", 1.0);
        qHorseTime.put("q2", 2.0);
        qHorseTime.put("q3", 3.0);
        tHorseTime.put("t1", 1.5);
        tHorseTime.put("t2", 2.5);
        tHorseTime.put("t3", 3.5);
        qHorse = new ArrayList<String>(Arrays.asList("q1", "q2", "q3"));
    }

    public void permutate(ArrayList<String> result, ArrayList<String> horse){
        if(horse.size() == 0){
            outputResult(result);
            return;
        }
        for(int i = 0; i < horse.size(); i++){
            ArrayList<String> newResult = (ArrayList<String>) result.clone();
            newResult.add(horse.get(i));
            ArrayList<String> newHorse = (ArrayList<String>) horse.clone();
            newHorse.remove(horse.get(i));
            permutate(newResult, newHorse);
        }
    }

    private void outputResult(ArrayList<String> result) {

        int TWinTimes = compare(result, qHorse);
        if(TWinTimes > result.size()/2){
            System.out.println("Tian's horses order: ");
            System.out.println(result);
            System.out.println("Qi's horses order: ");
            System.out.println(qHorse);
            System.out.println("Tian Win!");
        }
        else{
            System.out.println("Qi Win!");
        }
    }

    private int compare(ArrayList<String> tHorse, ArrayList<String> qHorse) {
        int score = 0;
        for(int i = 0; i < tHorse.size(); i++){
            if(tHorseTime.get(tHorse.get(i)) < qHorseTime.get(qHorse.get(i))){
                score++;
            }
        }
        return score;
    }

    @Test
    public void test(){
        HorseRace horseRace = new HorseRace();
        ArrayList tHorse = new ArrayList(Arrays.asList("t1", "t2", "t3"));
        ArrayList<String> result = new ArrayList();
        horseRace.permutate(result, tHorse);
    }
}
