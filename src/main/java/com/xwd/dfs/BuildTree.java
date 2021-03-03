package com.xwd.dfs;

import com.xwd.util.tree.TreeNode;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int leftPre, int rightPre, int leftIn, int rightIn) {
        if (leftPre > rightPre || leftIn > rightIn) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[leftPre]);
        int rootIn = leftIn;
        while (rootIn <= rightIn && inorder[rootIn] != preorder[leftPre]){
            rootIn++;
        }
        int left = rootIn - leftIn;
        node.left = buildTree(preorder, inorder, leftPre + 1, leftPre + left, leftIn, rootIn - 1);
        node.right = buildTree(preorder, inorder, leftPre + left + 1, rightPre, rootIn + 1, rightIn);
        return node;
    }

}
