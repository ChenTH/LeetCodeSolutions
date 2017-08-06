package com.cth.decode.tree.Easy;

import com.cth.decode.tree.util.TreeNode;

public class PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root==null){return false;};
    	return DFS(root, 0, sum);
    }
    public boolean DFS(TreeNode node,int sum,int target){
    	if(node.left==null&&node.right==null){
    		if(sum+node.val==target){
    			return true;
    		}
    		else {
				return false;
			}
    	}
    	boolean d1=false;
    	boolean d2=false;
    	if(node.left!=null){
    		d1=DFS(node.left, sum+node.val, target);
    	}
    	if(node.right!=null){
    		d2=DFS(node.right, sum+node.val, target);
    	}
    	return d1||d2;
    }
}
