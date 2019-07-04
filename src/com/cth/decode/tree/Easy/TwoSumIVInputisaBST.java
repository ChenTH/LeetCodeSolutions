package com.cth.decode.tree.Easy;

import com.cth.decode.tree.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SherlockTHao on 2017/8/6.
 */
public class TwoSumIVInputisaBST {
    public static boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        DLR(list, root);
        Integer[] numsArr = list.toArray(new Integer[list.size()]);
        Arrays.sort(numsArr);
        int start = 0, end = numsArr.length - 1;
        while (start < end) {
            int sum = numsArr[start] + numsArr[end];
            if (sum > k) {
                end--;
            } else if (sum < k) {
                start++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void DLR(List<Integer> list, TreeNode node) {
        if (node != null) {
            list.add(node.val);
            DLR(list, node.left);
            DLR(list, node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        findTarget(node1, 9);
    }
}
