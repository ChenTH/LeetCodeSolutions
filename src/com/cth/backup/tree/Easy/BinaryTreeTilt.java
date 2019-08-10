package com.cth.backup.tree.Easy;

import com.cth.backup.tree.util.TreeNode;

/**
 * Created by SherlockTHao on 2017/5/17.
 */
public class BinaryTreeTilt {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        node2.left = node4;
        node1.left = node3;
        root.left = node1;
        root.right = node2;

        System.out.print(findTilt(root));
    }

    static int res = 0;

    public static int findTilt(TreeNode root) {
        calculateTilt(root);
        return res;
    }

    public static int calculateTilt(TreeNode node) {
        if (node == null) return 0;
        int lsum = calculateTilt(node.left);
        int rsum = calculateTilt(node.right);
        res += Math.abs(lsum - rsum);
        return node.val + lsum + rsum;
    }
}
