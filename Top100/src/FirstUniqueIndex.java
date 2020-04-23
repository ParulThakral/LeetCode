import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueIndex {

    public static void main(String [] args){
        String s = "leetcode";

        System.out.println(new FirstUniqueIndex().firstUniqChar(s));

    }

    public int firstUniqChar(String s) {

        int repeatedIndex = -1;
        if(s == null || s.length() == 0) {
            return repeatedIndex;
        }
        Map<Character,Integer> frequencyMap = new LinkedHashMap<>();


        char [] ch = s.toCharArray();

        for(int i=0; i<ch.length; i++){

                frequencyMap.put(ch[i], frequencyMap.getOrDefault(ch[i], 0) +1);
        }

        for (Map.Entry<Character,Integer> entry : frequencyMap.entrySet()){
            if(entry.getValue() == 1){
                s.indexOf(entry.getKey());
            }
        }

        return repeatedIndex;
    }
}