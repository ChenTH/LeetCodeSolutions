package com.cth.backup.array.Medium;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {1, 2, 4, 5, 6, 3, 7, 8, 9, 10, 11};
        int[] b = {5, 4, 6, 2, 1, 3, 8, 10, 9, 11, 7};
        buildTree(a, b);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        int index = 0;
        int tar = 0;
        TreeNode root = new TreeNode(preorder[index]);
        for (int i = 0; i <= inorder.length - 1; i++) {
            if (inorder[i] == preorder[index]) {
                tar = i;
                break;
            }
        }
        root.left = genenate(0, tar - 1, index + 1, preorder, inorder);
        root.right = genenate(tar + 1, preorder.length - 1, index + tar + 1, preorder, inorder);
        return root;
    }

    public static TreeNode genenate(int begin, int end, int index, int[] preorder, int[] inorder) {
        if (begin > end) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[index]);
        int tar = 0;
        for (int i = begin; i <= end; i++) {
            if (inorder[i] == preorder[index]) {
                tar = i;
                break;
            }
        }
        node.left = genenate(begin, tar - 1, index + 1, preorder, inorder);
        node.right = genenate(tar + 1, end, index + tar - begin + 1, preorder, inorder);
        return node;
    }

    ;
}
