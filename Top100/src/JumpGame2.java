public class JumpGame2 {

    public static void main(String [] args){
        int [] array = {8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,
                6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
        int [] array2 = {1,2,4,4,3,1};
        System.out.println(new JumpGame2().jump(array2));
    }

    int globalJumpMin = Integer.MAX_VALUE;
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }

        calculateAllJumps(nums, 0, 0);
        return globalJumpMin;
    }

    private void calculateAllJumps(int [] nums, int index, int jumpCount){
        if(index == nums.length-1){
            globalJumpMin = Math.min(globalJumpMin, jumpCount);
            jumpCount = 0;
        }
        if (index >= nums.length){
            return;
        }
        int val = nums[index];
        jumpCount++;

        for (int i=1;i<=val;i++){
            calculateAllJumps(nums, index+i, jumpCount);
        }
    }
}