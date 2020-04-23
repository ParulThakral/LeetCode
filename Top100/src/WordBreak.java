import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("cats");
        wordDict.add("dog");

        System.out.println(new WordBreak().wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder(s);

        String replacedString = "1";
        for (String word : wordDict) {
            if (s.contains(word)) {
                WordBreak.replaceString(sb, word, replacedString);

            }
        }

        String result = sb.toString();

        char [] charArray = result.toCharArray();
        for(char c: charArray){
            if(c!='1'){
                return false;
            }
        }
        return true;
    }

    public static void replaceString(StringBuilder sb,
                                     String toReplace,
                                     String replacement) {
        int index = -1;
        while ((index = sb.lastIndexOf(toReplace)) != -1) {
            sb.replace(index, index + toReplace.length(), replacement);
        }
    }
}