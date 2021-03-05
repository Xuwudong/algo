package com.xwd.recursion;

import com.xwd.util.tree.TreeNode;

/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-03-03 11:38
 **/
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return false;
        }
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
