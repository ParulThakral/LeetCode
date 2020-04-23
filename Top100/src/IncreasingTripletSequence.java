public class IncreasingTripletSequence {

    public static void main(String [] args){
        int [] nums = {2,1,5,0,4,6};

        System.out.println(new IncreasingTripletSequence().increasingTriplet(nums));
    }

    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3){
            return false;
        }

        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for(int num: nums){
            if(num <= firstMin){
                firstMin = num;
            }
            else if(num <= secondMin){
                secondMin = num;
            }
            else{
                return true;
            }
        }

        return false;

    }
}