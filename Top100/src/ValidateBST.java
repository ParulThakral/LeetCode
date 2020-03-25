import java.util.ArrayList;
        import java.util.List;

public class ValidateBST {
    /*    Validate Binary Search Tree
        Assume a BST is defined as follows:

        The left subtree of a node contains only nodes with keys less than the node's key.
        The right subtree of a node contains only nodes with keys greater than the node's key.
        Both the left and right subtrees must also be binary search trees.

        Example 1:

                 2
                / \
               1   3

        Input: [2,1,3]
        Output: true
        Example 2:

                 5
                / \
               1   4
              /     \
             3       6

        Input: [5,1,4,null,null,3,6]
        Output: false
        Explanation: The root node's value is 5 but its right child's value is 4.*/
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(2, null, null), new TreeNode(8, null, null));
        System.out.println(new ValidateBST().isValidBSTSolution1(root));
        System.out.println(new ValidateBST().isValidBSTSolution2(root));
    }

    /*Solution using in-order property for a Binary search tree
     * In order traversal of a binary search tree is always sorted
     * */
    public boolean isValidBSTSolution1(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> resultList = new ArrayList<>();
        inOrderTraversal(root, resultList);

        for (int i = 0; i < resultList.size() - 1; i++) {
            if (resultList.get(i) >= resultList.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public boolean isValidBSTSolution2(TreeNode root) {

        return isRootInRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isRootInRange(TreeNode root, int left, int right) {

        if (root == null) {
            return true;
        }

        if (root.val <= left) {
            return false;
        }

        if (root.val >= right) {
            return false;
        }

        if (!isRootInRange(root.left, left, root.val)) {
            return false;
        }
        if (!isRootInRange(root.right, root.val, right)) {
            return false;
        }

        return true;

    }

    private void inOrderTraversal(TreeNode root, List<Integer> resultList) {
        if (root != null) {
            inOrderTraversal(root.left, resultList);
            resultList.add(root.val);
            inOrderTraversal(root.right, resultList);
        }
    }

}
