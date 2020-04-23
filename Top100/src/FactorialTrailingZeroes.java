public class FactorialTrailingZeroes {

    public static void main(String [] args){
        int n = 30;
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(n));

    }
    public int trailingZeroes(int n) {
        if(n <=0){
            return 0;
        }

        double factorial = getFactorial2(n);
        int trailingZeroes = 0;
        while(factorial%10==0){
            trailingZeroes++;
            factorial = factorial/10;
        }

        return trailingZeroes;
    }

    private double getFactorial2(int n){
        double factorial = 1;
        if (n <=1){
            return factorial;
        }

        for(int i=n; i>=1; i--){
            factorial = i * factorial;
        }

        return factorial;
    }

    private int getFactorial(int n){
        if (n <=1){
            return 1;
        }

        return n*getFactorial(n-1);
    }
}