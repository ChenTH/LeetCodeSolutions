package com.cth.decode.tree.Medium;

import com.cth.decode.tree.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by SherlockTHao on 2017/5/17.
 */
public class FindLargestValueinEachTreeRow {
    //自己做的方法
    public class TreeNodeRow {
        TreeNode node;
        int rows;

        TreeNodeRow(TreeNode node, int rows) {
            this.node = node;
            this.rows = rows;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNodeRow> queue = new LinkedList<>();
        queue.offer(new TreeNodeRow(root, 1));
        int rows = 1;
        int max = root.val;
        res.add(max);
        while (!queue.isEmpty()) {
            TreeNodeRow t = queue.poll();
            if (t.rows == rows) {
                if (t.node.val > max) {
                    max = t.node.val;
                }
            } else {
                res.add(max);
                rows = t.rows;
                max = t.node.val;
            }
            if (t.node.left != null)
                queue.offer(new TreeNodeRow(t.node.left, t.rows + 1));
            if (t.node.right != null)
                queue.offer(new TreeNodeRow(t.node.right, t.rows + 1));
        }
        res.add(max);
        return res;
    }

    //网上的bfs方法
    public int[] findValueMostElement(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        queue.add(root);
        int queueSize = root == null ? 0 : 1;
        while (queueSize > 0) {
            int largestElement = Integer.MIN_VALUE;
            for (int i = 0; i < queueSize; i++) {
                TreeNode cur = queue.poll();
                largestElement = Math.max(cur.val, largestElement);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            res.add(largestElement);
            queueSize = queue.size();
        }
        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) resArray[i] = res.get(i);
        return resArray;
    }

    //网上的DFS方法
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int d) {
        if (root == null) {
            return;
        }
        //expand list size
        if (d == res.size()) {
            res.add(root.val);
        } else {
            //or set value
            res.set(d, Math.max(res.get(d), root.val));
        }
        helper(root.left, res, d + 1);
        helper(root.right, res, d + 1);
    }
}
