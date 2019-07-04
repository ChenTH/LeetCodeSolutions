package com.cth.decode.tree.Easy;

import com.cth.decode.tree.util.TreeNode;

/**
 * Created by SherlockTHao on 2017/5/17.
 */
public class DiameterofBinaryTree {
//    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int[] max = {0};
        calDia(root, max);
        return max[0] - 1;
    }

    public int calDia(TreeNode node, int[] max) {
        if (node == null) return 0;
        int ll = calDia(node.left, max);
        int rl = calDia(node.right, max);
        if (ll + rl + 1 > max[0]) {
            max[0] = ll + rl + 1;
        }
        return ll > rl ? ll + 1 : rl + 1;
    }
}
