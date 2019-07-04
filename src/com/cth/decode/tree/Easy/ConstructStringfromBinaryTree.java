package com.cth.decode.tree.Easy;

import com.cth.decode.tree.util.TreeNode;

/**
 * Created by SherlockTHao on 2017/8/6.
 */
public class ConstructStringfromBinaryTree {
    public static String tree2str(TreeNode t) {
        if (t == null) return "";
        StringBuilder sb = new StringBuilder();
        DLR(t, sb);
        return sb.toString();
    }

    public static void DLR(TreeNode t, StringBuilder sb) {
        if (t != null) {
            sb.append(t.val);
            if (t.right != null) {
                sb.append('(');
                DLR(t.left, sb);
                sb.append(')');
                sb.append('(');
                DLR(t.right, sb);
                sb.append(')');
            }
            if (t.left != null && t.right == null) {
                sb.append('(');
                DLR(t.left, sb);
                sb.append(')');
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node2.right = node4;
        node2.left = node3;
        System.out.print(tree2str(node1));
    }
}
