package com.xwd.recursion;

import com.xwd.util.tree.TreeNode;
import com.xwd.util.tree.TreeUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @program: algo
 * @description: 687
 * @author: xuwudong
 * @create: 2021-03-08 17:31
 **/
public class LongestUnivaluePath {

    private int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        arrowLength(root);
        return ans;
    }

    /**
     * 求从该node出发最长的箭头
     *
     * @param node
     * @return
     */
    private int arrowLength(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.val == node.left.val) {
            arrowLeft = left + 1;
        }
        if (node.right != null && node.val == node.right.val) {
            arrowRight = right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }

    public static void main(String[] args) {
        LongestUnivaluePath l = new LongestUnivaluePath();
        List<Integer> list = Arrays.asList(5, 4, 5, 1, 1, null, 5);
        TreeNode root = TreeUtil.buildTree(list);
        System.out.println(l.longestUnivaluePath(root));

        list = Arrays.asList(1, 4, 5, 4, 4, null, 5);
        root = TreeUtil.buildTree(list);
        System.out.println(l.longestUnivaluePath(root));
    }
}
