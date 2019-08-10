package com.cth.backup.tree.Easy;

import com.cth.backup.tree.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SherlockTHao on 2017/5/17.
 */
public class FindModeinBinarySearchTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        node1.left = node2;
        node2.left = node3;
        findMode(node1);
    }

    public static int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        calMode(root, map);
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (Integer i : map.keySet()) {
            int count = map.get(i);
            if (count > max) {
                list.clear();
                list.add(i);
                max = count;
            } else if (count == max) {
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void calMode(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) return;
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        calMode(node.left, map);
        calMode(node.right, map);
    }
//    public static int[] findMode(TreeNode root) {
//        List<Integer> list=new ArrayList<>();
//        int[] maxCount=new int[1];
//        calMode(root,list,maxCount);
//        int[] res=new int[list.size()];
//        for(int i=0;i<res.length;i++){
//            res[i]=list.get(i);
//        }
//        return res;
//    }
//    public static void calMode(TreeNode node,List<Integer> list,int[] maxCount){
//        if(node==null) return;
//        int count=cal(node,node.val);
//        TreeNode leftNode=node.left;
//        while (leftNode!=null && leftNode.val==node.val){
//            leftNode=leftNode.left;
//        }
//        TreeNode rightNode=node.right;
//        while (rightNode!=null && rightNode.val==node.val){
//            rightNode=rightNode.right;
//        }
//        if(count==maxCount[0]){
//            list.add(node.val);
//        }
//        else if(count>maxCount[0]){
//            list.clear();
//            list.add(node.val);
//            maxCount[0]=count;
//        }
//        calMode(leftNode,list,maxCount);
//        calMode(rightNode,list,maxCount);
//    }
//    public static int cal(TreeNode node,int val){
//        if(node==null || node.val!=val) {
//            return 0;
//        }
//        else {
//            int r=cal(node.right,node.val);
//            int l=cal(node.left,node.val);
//            return r+l+1;
//        }
//    }
}
