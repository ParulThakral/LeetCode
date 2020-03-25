public class ShortestUnsortedArray {

    public static void main(String[] args) {
        int[] array = {1,3,3,3,3,3,3,2,2,2};

        System.out.println(new ShortestUnsortedArray().findUnsortedSubarray(array));
    }

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int startIndex = 0;
        int endIndex = nums.length - 1;
        boolean shouldCalulate = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (!(nums[i] <= nums[i + 1])) {
                startIndex = i;
                shouldCalulate = true;
                break;
            }
        }

        for (int i = nums.length - 1; i > 0; i--) {
            if (!(nums[i] >= nums[i - 1])) {
                endIndex = i;
                shouldCalulate = true;
                break;
            }
        }

        if (shouldCalulate) {

            while (startIndex > 0 && nums[startIndex] == nums[startIndex - 1]) {
                startIndex--;
            }
            while (endIndex < nums.length - 1 && nums[endIndex] == nums[endIndex + 1]) {
                endIndex++;
            }

            return endIndex - startIndex + 1;

        }
        return 0;


    }

}
