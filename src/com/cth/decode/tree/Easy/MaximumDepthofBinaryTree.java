package com.cth.decode.tree.Easy;

import com.cth.decode.tree.util.TreeNode;

public class MaximumDepthofBinaryTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return l > r ? l + 1 : r + 1;
    }
}

