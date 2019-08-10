package com.cth.backup.tree.Easy;

import com.cth.backup.tree.util.TreeNode;

public class SameTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null && q != null) {
            return false;
        } else if (p != null && q == null) {
            return false;
        }
        ;
        if (p.val != q.val) {
            return false;
        }
        ;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
