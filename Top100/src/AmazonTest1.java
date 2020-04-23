import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class AmazonTest1 {

    public static void main(String [] args){
        int []states = {1,1,1,0,1,1,1,1};
        int days = 2;

        System.out.println(new AmazonTest1().cellCompete1(states, days));
    }
    public List<Integer> cellCompete(int[] states, int days)
    {
        if (states == null || days<0){
            return null;
        }
        int [] nextDayStates = new int[states.length];

        for(int i=1;i<=days;i++){
            if(states[1]==1){
                nextDayStates[0] = 1;
            }
            else {
                nextDayStates[0] = 0;
            }

            for(int j=1; j<states.length-1;j++){
                if(states[j-1]!=states[j+1]){
                    nextDayStates[j]=1;
                }
                else {
                    nextDayStates[j] = 0;
                }
            }
            if(states[states.length-2] == 1){
                nextDayStates[nextDayStates.length-1]=1;
            }
            else{
                nextDayStates[nextDayStates.length-1]=0;
            }
            states = nextDayStates.clone();
        }

        List<Integer> resultList = new ArrayList<>();
        for(int state: nextDayStates) {
            resultList.add(state);
        }
        return resultList;
    }
    public List<Integer> cellCompete1(int[] states, int days) {
        while (days > 0) {
            int[] nextDayStates = states.clone();
            for (int i = 0; i < states.length; i++) {
                int prevState = (i == 0) ? 0 : states[i - 1];
                int nextState = (i == states.length - 1) ? 0 : states[i + 1];
                nextDayStates[i] = prevState ^ nextState;
                days--;
                states = nextDayStates;
            }
        }
        return Arrays.stream(states).boxed().collect(Collectors.toList());
    }
}