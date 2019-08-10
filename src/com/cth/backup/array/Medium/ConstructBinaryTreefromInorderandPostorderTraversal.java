package com.cth.backup.array.Medium;

public class ConstructBinaryTreefromInorderandPostorderTraversal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {5, 6, 4, 2, 10, 11, 9, 8, 7, 3, 1};
        int[] b = {5, 4, 6, 2, 1, 3, 8, 10, 9, 11, 7};
        buildTree(a, b);
    }

    public static TreeNode buildTree(int[] postorder, int[] inorder) {
        if (postorder.length == 0) {
            return null;
        }
        int index = postorder.length - 1;
        int tar = 0;
        TreeNode root = new TreeNode(postorder[index]);
        for (int i = 0; i <= inorder.length - 1; i++) {
            if (inorder[i] == postorder[index]) {
                tar = i;
                break;
            }
        }
        root.left = genenate(0, tar - 1, index - postorder.length + tar, postorder, inorder);
        root.right = genenate(tar + 1, postorder.length - 1, index - 1, postorder, inorder);
        return root;
    }

    public static TreeNode genenate(int begin, int end, int index, int[] postorder, int[] inorder) {
        if (begin > end) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[index]);
        int tar = 0;
        for (int i = begin; i <= end; i++) {
            if (inorder[i] == postorder[index]) {
                tar = i;
                break;
            }
        }
        node.left = genenate(begin, tar - 1, index - end + tar - 1, postorder, inorder);
        node.right = genenate(tar + 1, end, index - 1, postorder, inorder);
        return node;
    }

    ;
}
