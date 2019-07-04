package com.cth.decode.tree.Easy;

import com.cth.decode.tree.util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversalII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        ;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> queueNo = new LinkedList<Integer>();
        queue.offer(root);
        queueNo.offer(1);
        while (!(queue.isEmpty())) {
            int level = queueNo.peek();
            List<Integer> list = new LinkedList<>();
            while (!(queueNo.isEmpty()) && queueNo.peek() == level) {
                TreeNode node = queue.poll();
                list.add(node.val);
                queueNo.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    queueNo.offer(level + 1);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    queueNo.offer(level + 1);
                }
            }
            stack.push(list);
        }
        while (!(stack.isEmpty())) {
            result.add(stack.pop());

        }
        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        DFS(result, 0, root);
        List<List<Integer>> result2 = new LinkedList<>();
        int size = result.size();
        for (int i = 0; i < size; i++) {
            result2.add(result.get(size - i - 1));
        }
        return result2;
    }

    public void DFS(List<List<Integer>> result, int level, TreeNode node) {
        if (node == null) {
            return;
        }
        ;
        if (result.size() <= level) {
            result.add(new LinkedList<Integer>());
        }
        result.get(level).add(node.val);
        DFS(result, level + 1, node.left);
        DFS(result, level + 1, node.right);

    }
}
