package com.xwd.recursion;

import com.xwd.util.tree.TreeNode;
//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
// Related Topics 树 深度优先搜索 递归
// 👍 806 👎 0

/**
 * @program: algo
 * @description:104
 * @author: xuwudong
 * @create: 2021-03-03 10:03
 **/
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    private int max;

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return max;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            if (depth > max) {
                max = depth;
            }
            return;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
