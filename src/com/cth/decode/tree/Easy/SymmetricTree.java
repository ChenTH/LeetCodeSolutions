package com.cth.decode.tree.Easy;

import com.cth.decode.tree.util.TreeNode;

public class SymmetricTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        ;
        if (root.left == null && root.right == null) {
            return true;
        }
        ;
        return isMiror(root, root);
    }

    public boolean isMiror(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        ;
        if (n1 == null && n2 != null) {
            return false;
        }
        ;
        if (n1 != null && n2 == null) {
            return false;
        }
        ;
        if (n1.val != n2.val) return false;
        return isMiror(n1.left, n2.right) && isMiror(n1.right, n2.left);
    }
}
