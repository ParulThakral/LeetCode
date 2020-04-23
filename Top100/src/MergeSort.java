public class MergeSort {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;


        new MergeSort().merge2(nums1, m, nums2, n);
        System.out.println(nums1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            return;
        }
        int[] result = new int[n + m];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                result[k++] = nums1[i++];

            } else {
                result[k++] = nums2[j++];

            }
        }

        while (i < m) {
            result[k++] = nums1[i++];
        }

        while (j < n) {
            result[k++] = nums1[j++];
        }

        for (int a = 0; a < n + m; a++) {
            nums1[a] = result[a];
        }

    }

    private void merge2(int[] nums1, int n, int[] nums2, int m) {
        int k = n + m - 1;
        n = n - 1;
        m = m - 1;
        while (n >= 0 && m >= 0) {
            nums1[k--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }

        while (n >= 0) {
            nums1[k--] = nums2[n--];
        }
    }
}