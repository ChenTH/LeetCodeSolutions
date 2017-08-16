package com.cth.decode.tree.Hard;

import com.cth.decode.tree.util.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by SherlockTHao on 2017/8/15.
 */
public class SerializeandDeserializeBinaryTree {
    public static void main(String[] args){
        Codec cd=new Codec();
        String str="1!2!3!#!#!4!5!";
        TreeNode node=cd.deserialize(str);
        String date=cd.serialize(node);
    }
}
 class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        serializeTree(root,sb);
        return sb.toString();
    }
    private void serializeTree(TreeNode node,StringBuilder sb){
        if(node==null){
            sb.append("#!");
            return;
        }
        sb.append(node.val+"!");
        serializeTree(node.left,sb);
        serializeTree(node.right,sb);

    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split("!")));
        return deserializeTree(nodes);
    }
    private TreeNode deserializeTree(Deque<String> nodes) {
        String val = nodes.remove();
        if("#".equals(val)){
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(val));
        node.left=deserializeTree(nodes);
        node.right=deserializeTree(nodes);
        return node;
    }
}