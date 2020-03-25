import org.jetbrains.annotations.NotNull;

public class ProductExceptSelf {

    public static void main(String [] args){
        int [] array = {1,2,3,4};

        int [] result = new ProductExceptSelf().getProductExceptSelf(array);
        System.out.println(result);

    }

    public int [] getProductExceptSelf(@NotNull int [] nums){
        int [] result = new int [nums.length];
        // this array will have product of all nums left of num at index i
        int [] leftArray = new int [nums.length];

        leftArray[0] = 1;
        for(int i=1; i<nums.length;i++){
            leftArray[i] = leftArray[i-1]*nums[i-1];
        }
       /* rightArray[nums.length-1]=1;
        // populate right array
        for(int i=nums.length-2; i>=0;i--){
            rightArray[i] = rightArray[i+1]*nums[i+1];
        }*/
       int right = 1;
       for(int i=nums.length-1;i>=0;i--){
           leftArray[i]= leftArray[i]*right;
           right = right*nums[i];

       }


        return leftArray;

    }
}
