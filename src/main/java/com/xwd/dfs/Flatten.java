package com.xwd.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 *114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class Flatten {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preOrderTraverse(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    private void preOrderTraverse(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preOrderTraverse(root.left, list);
            preOrderTraverse(root.right, list);
        }
    }
}
