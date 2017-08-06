package com.cth.decode.tree.Easy;

import com.cth.decode.tree.util.TreeNode;

public class LowestCommonAncestorofaBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	TreeNode node=root;
    	int a=p.val;
    	int b=q.val;
    	while (true) {
    		int c=node.val;
    		if((a<=c&&b>=c)||(a>=c&&b<=c)){
    			return node;
    		}
    		if(a<c&&b<c){
    			node=node.left;
    		}
    		else {
				node=node.right;
			}
    		
		}
    }
}
