package com.cth.decode.hashtable;

import com.cth.decode.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by SherlockTHao on 2017/3/17 0017.
 */
public class MostFrequentSubtreeSum {
    public static void main(String[] args) {

    }

//    public int[] findFrequentTreeSum(TreeNode root) {
//        if(root==null){
//            return new int[0];
//        }
//        HashMap<Integer, Integer> map = new HashMap<>();
//        List<Integer> list=new ArrayList<>();
//        lrd(root, map);
//        int max = 0;
//        for (Integer i : map.keySet()) {
//            if(map.get(i)>max){
//                list.clear();
//                list.add(i);
//                max=map.get(i);
//            }
//            else if(map.get(i)==max){
//                list.add(i);
//            }
//        }
//        int[] result=new int[list.size()];
//        for(int i=0;i<list.size();i++){
//            result[i]=list.get(i);
//        }
//        return result;
//    }

//    public int lrd(TreeNode node, HashMap<Integer, Integer> map) {
//        TreeNode left = node.left;
//        TreeNode right = node.right;
//        if (left == null && right == null) {
//            mapAdd(map, node.val);
//            return node.val;
//        } else {
//            int leftSum = 0;
//            int rightSum = 0;
//            if (left != null) {
//                leftSum = lrd(left, map);
//            }
//            if (right != null) {
//                rightSum = lrd(right, map);
//            }
//            int res = leftSum + rightSum + node.val;
//            mapAdd(map, res);
//            return res;
//        }
//    }

    public void mapAdd(HashMap<Integer, Integer> map, int val) {
        if (map.containsKey(val)) {
            map.put(val, map.get(val) + 1);
        } else {
            map.put(val, 1);
        }
    }
}
