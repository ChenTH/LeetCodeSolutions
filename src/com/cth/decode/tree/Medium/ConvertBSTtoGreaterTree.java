package com.cth.decode.tree.Medium;

import com.cth.decode.tree.TreeNode;

/**
 * Created by SherlockTHao on 2017/5/17.
 */
public class ConvertBSTtoGreaterTree {

    public TreeNode convertBST(TreeNode root) {
        int[] sum = {0};
        calSum(root, sum);
        return root;
    }

    public void calSum(TreeNode node, int[] sum) {
        if (node == null) return;
        calSum(node.right, sum);
        int tem = node.val;
        if (sum[0] != 0) {
            node.val = node.val + sum[0];
        }
        sum[0] += tem;
        calSum(node.left, sum);
    }
}
