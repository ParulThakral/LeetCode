public class FirstMissingPositive {
    /*Given an unsorted integer array, find the smallest missing positive integer.*/
    public static void main(String [] args){
        int [] nums = {7,8,9,11,12};

        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        int maxInt = Integer.MAX_VALUE;

        for(int i=1; i<=maxInt; i++){
            if(!linearSearch(nums, i)){
                return i;
            }
        }

        return -1;

    }

    private boolean linearSearch(int [] nums, int target){
        for(int num: nums){
            if(target == num){
                return true;
            }
        }

        return false;

    }
}