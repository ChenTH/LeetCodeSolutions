package com.cth.backup.tree.Easy;

import com.cth.backup.tree.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> queueNo = new LinkedList<Integer>();
        queue.offer(root);
        queueNo.offer(1);
        while (true) {
            TreeNode node = queue.poll();
            int i = queueNo.poll();
            if (node.left == null && node.right == null) {
                return i;
            }
            if (node.left != null) {
                queue.offer(node.left);
                queueNo.offer(i + 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                queueNo.offer(i + 1);
            }
        }
    }
}
