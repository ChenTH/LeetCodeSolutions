package com.cth.backup.tree.Easy;

import com.cth.backup.tree.util.TreeNode;

/**
 * Created by SherlockTHao on 2017/8/6.
 */
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        int num = 0;
        if (t1 != null) num += t1.val;
        if (t2 != null) num += t2.val;
        TreeNode node = new TreeNode(num);
        node.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        node.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return node;
    }
}
