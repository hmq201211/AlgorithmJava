package q654;

import common.TreeNode;

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int start, int end) {
        if (start > end)
            return null;
        int max = nums[start];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = construct(nums, start, index - 1);
        root.right = construct(nums, index + 1, end);
        return root;
    }

    public static void main(String[] args) {
        new Solution().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }
}