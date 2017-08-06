package com.cth.decode.tree.Easy;

public class BalancedBinaryTree {
	public boolean flag =true;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isBalanced(TreeNode root) {
		maxDepth(root);
		return flag;
    }
    public int maxDepth(TreeNode root) {
    	if(root==null){
    		return 0;
    	}
    	int l=maxDepth(root.left);
    	int r=maxDepth(root.right);
    	if(flag==true){
        	if(Math.abs(l-r)>1){
        		 flag=false;
        	}
    	}
		return l>r? l+1:r+1;
    }
}
