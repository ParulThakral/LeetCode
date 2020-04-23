import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmazonTest3 {
    public static void main(String [] args){
        
    }
    public List<String> reorderLines(int logFileSize, List<String> logLines){

        List<String> logWithLetters = new ArrayList<>();
        List<String> logWithDigits = new ArrayList<>();
        List<String> resultLogs = new ArrayList<>();

        // Splitting log lines with only digits and log lines with only letters
        for (String log : logLines) {
            if(Character.isDigit(log.split("\\s+")[1].charAt(0))) {
                logWithDigits.add(log);
            }
            else {
                logWithLetters.add(log);
            }
        }
        // lexicographically sorting logs with letters
        Collections.sort(logWithLetters, (o1, o2) -> {
            String[] string1 = o1.split("\\s+");
            String[] string2 = o2.split("\\s+");

            StringBuilder stringBuilderA = new StringBuilder();
            StringBuilder stringBuilderB = new StringBuilder();

            for (int i=1; i<string1.length; i++) {
                stringBuilderA.append(string1[i]).append(" ");
            }

            for (int i=1; i<string2.length; i++) {
                stringBuilderB.append(string2[i]).append(" ");
            }

            int i = stringBuilderA.toString().compareTo(stringBuilderB.toString());
            if (i == 0) {
                return string1[0].compareTo(string2[0]);
            }

            return i;
        });

        // Add both the lists in the order such as sorted letter logs comes before digit logs
        resultLogs.addAll(logWithLetters);
        resultLogs.addAll(logWithDigits);

        return resultLogs;
    }

}
