import java.util.Arrays;

public class JumpGame {

    public static void main(String [] args){
        int [] array = {3,2,1,0,4};
        System.out.println(new JumpGame().canJump(array));

    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0){
            return true;
        }

        int [] result = new int[nums.length];

        Arrays.fill(result, 0);
        result[0] =1;
        int val = 0;
        int resultIndex = 1;
        for(int i=0; i<nums.length; i++){
            resultIndex = i+1;
            val = nums[i];

            if(result[i]==0){
                return false;
            }

            while(val > 0 && resultIndex<nums.length){
                result[resultIndex++] = 1;
                val--;
            }

            if(resultIndex == nums.length-1 && result[nums.length-1] == 1){
                return true;
            }


        }


        return result[nums.length-1]==1?true:false;

    }
}