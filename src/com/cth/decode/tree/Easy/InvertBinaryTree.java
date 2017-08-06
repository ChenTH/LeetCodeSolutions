package com.cth.decode.tree.Easy;

import com.cth.decode.tree.util.TreeNode;

public class InvertBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public TreeNode invertTree(TreeNode root) {
    	invert(root);
        return root;
    }
    public void invert(TreeNode node) {
		if(node==null){return;};
		TreeNode child=node.right;
		node.right=node.left;
		node.left=child;
		invert(node.left);
		invert(node.right);
	}
}
