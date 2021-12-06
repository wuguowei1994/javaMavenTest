package com.wuguowei.test;

import java.util.HashMap;

public class RebuildTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // 前序遍历
    int[] preorder;

    // 存放中序遍历里<val, index>
    HashMap<Integer, Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;

        for (int i = 0; i <= inorder.length - 1; i++) {
            dic.put(inorder[i], i);
        }

        return recur(0, 0, inorder.length - 1);
    }

    /**
     * @param root 前序遍历根节点的index
     * @param left 前序遍历的左区间
     * @param right 前序遍历的右区间
     * @return 重建后的二叉树
     */
    private TreeNode recur(int root, int left, int right) {
        if (left > right) {
            return null;
        }

        // 建立根节点
        TreeNode rootNode = new TreeNode(preorder[root]);

        // 找出中序遍历的index, 这个index会用来划分左右子树
        int index = dic.get(preorder[root]);

        // 左子树, 左子树不改left
        rootNode.left = recur(root + 1, left, index - 1);

        // 右子树, 右子树不改right
        // 左子树长度为 index - left, 所以新 root = 旧root + 区间长度 + 1
        rootNode.right = recur(root + index - left + 1, index + 1, right);

        return rootNode;
    }
}
