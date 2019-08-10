package com.cth.backup.tree.Medium;

import com.cth.backup.tree.util.TreeNode;

/**
 * Created by SherlockTHao on 2017/5/20.
 */
public class ValidateBinarySearchTree {
    //    boolean flag=true;
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        isValidBST(node1);
    }

    public static boolean isValidBST(TreeNode root) {
        return isVaild(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isVaild(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isVaild(node.left, min, node.val) && isVaild(node.right, node.val, max);
    }
//    public int[] valid(TreeNode node){
//        if(node==null) return new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE};
//        if(node.left!=null&&node.left.val>node.val){
//            flag=false;
//        }
//        if(node.right!=null&&node.right.val>node.val){
//            //false
//        }
//        int [] left=valid(node.left);
//        if(left[1]>node.val){
//            //false
//        }
//        int[] right=valid(node.right);
//        if(right[0]>node.val){
//            //false
//        }
//        return new int[]{left[0],right[1]};
//    }
}
