package com.cth.decode.tree.Easy;

import com.cth.decode.tree.util.TreeNode;

/**
 * Created by SherlockTHao on 2017/8/11.
 */
public class ConvertSortedArraytoBinarySearchTree {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length - 1);
    }

    public static TreeNode createBST(int[] nums, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = createBST(nums, start, mid - 1);
            node.right = createBST(nums, mid + 1, end);
            return node;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6});
    }
}
