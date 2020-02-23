import java.util.Arrays;

public class FirstLastIndex {

    public static void main(String[] args){
        int [] nums = {5,7,7,8,8,8,10};
        int target = 8;
        int [] result = new FirstLastIndex().searchRange(nums, target);
        System.out.println(result);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] resultArray = new int[2];
        Arrays.fill(resultArray, -1);

        if (nums == null || nums.length == 0) {
            return resultArray;
        }

        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        int mid = (left + right) / 2;
        while (left <= right) {
            if (target == nums[mid]) {
                index = mid;
                break;
            }

            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

            mid = (left+right)/2;
        }

        if (index == -1) {
            return resultArray;
        }

        int leftIndex = index;
        int rightIndex = index;
        while (leftIndex > 0 && nums[leftIndex-1] == target) {
            leftIndex--;
        }

        while (rightIndex < nums.length-1 && nums[rightIndex+1] == target) {
            rightIndex++;
        }

        resultArray[0] = leftIndex;
        resultArray[1] = rightIndex;

        return resultArray;
    }
}