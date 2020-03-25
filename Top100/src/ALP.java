public class ALP {

    public static void main(String [] args){
        String string = "PPALLL";

        System.out.println(new ALP().checkRecord(string));

    }

    public boolean checkRecord(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        char[] charArray = s.toCharArray();
        int countA = 0;
        int countL = 0;
        for (char c : charArray) {
            if (c == 'A') {
                countA++;
            }
            if (c == 'L') {
                countL++;
            } else {
                countL = 0;
            }

            if (countA > 1) {
                return false;
            }
            if (countL > 2) {
                return false;
            }
        }

        if (countA > 1 || countL >2 ){
            return false;
        }
        return true;
    }
}