package com.cth.decode.tree;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> list=new ArrayList<>();
    	if(root==null){return list;};
    	getPath(root,"",list);
    	return list;
    }
    public void getPath(TreeNode node,String path,List<String> list) {
		if(node.left==null&&node.right==null){
			list.add(path+node.val);
		}
		if(node.left!=null){
			getPath(node.left,path+node.val+"->",list);
		}
		if(node.right!=null){
			getPath(node.right,path+node.val+"->",list);
		}
	}
}
