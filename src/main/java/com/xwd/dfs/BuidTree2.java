package com.xwd.dfs;

import com.xwd.util.tree.TreeNode;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuidTree2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] in, int[] post, int lIn, int rIn, int lPost, int rPost) {
        if (lIn > rIn || lPost > rPost) {
            return null;
        }
        TreeNode node = new TreeNode(post[rPost]);
        int rootIndex = lIn;
        while (rootIndex <= rIn && in[rootIndex] != post[rPost]) rootIndex++;
        int left = rootIndex - lIn;

        node.left = buildTree(in, post, lIn, lIn + left - 1, lPost, lPost + left - 1);
        node.right = buildTree(in, post, lIn + left + 1, rIn, lPost + left, rPost - 1);
        return node;
    }
}
