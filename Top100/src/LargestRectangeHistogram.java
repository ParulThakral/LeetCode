public class LargestRectangeHistogram {
    public static void main(String [] args){
        int [] nums = {2,1,5,6,2,3};

        System.out.println(new LargestRectangeHistogram().largestRectangleArea(nums));
    }

    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }

        int left = 0;
        int right = heights.length-1;
        int maxArea = 0;
        int currentArea;
        int globalMax = -1;
        while(left < right){
            globalMax = Math.max(globalMax, Math.max(heights[left], heights[right]));
            currentArea = Math.min(heights[left],heights[right]) * (right - left+1);
            maxArea = Math.max(maxArea, currentArea);
            if(heights[left] > heights[right]){
                right--;
            }
            else{
                left++;
            }

        }

        return Math.max(globalMax, maxArea);
    }
}