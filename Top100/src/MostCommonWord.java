import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostCommonWord {
    public static void main(String [] args){
        String paragraph = "a, a, a, a, b,b,b,c, c";
        String [] array = {"a"};
        System.out.println(new MostCommonWord().mostCommonWord(paragraph, array));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        String [] words = paragraph.split("[ !?;.,']+");

        String mostFrequentWord = null;
        int frequency = 0;
        Map<String, Integer> map = new HashMap<>();
        List<String> bannedList = Arrays.asList(banned);
        for(String word: words){
            if(!bannedList.contains(word)){
                int currentValue = map.getOrDefault(word, 0) + 1;
                if(currentValue >= frequency){
                    mostFrequentWord = word;
                    frequency = currentValue;
                }
                map.put(word, currentValue);
            }
        }

        return mostFrequentWord;
    }

    private String [] getListReplaced(String [] array){
        String [] result = new String[array.length];
        int index = 0;
        for (String word: array){

            word = word.replace("!","");
            word = word.replace("?","");
            word = word.replace("'","");
            word = word.replace(";","");
            word = word.replace(".","");
            word = word.replace(",","");
            result[index++] = word;
        }

        return result;
    }
}