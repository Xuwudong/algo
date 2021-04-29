package com.xwd.dfs;

import com.xwd.util.tree.TreeNode;
import com.xwd.util.tree.TreeUtil;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-04-29 12:09
 **/
public class LowestCommonAncestor {
    TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> queue1 = new LinkedList<>();
        Deque<TreeNode> queue2 = new LinkedList<>();
        dfs(root, p, queue1);
        dfs(root, q, queue2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1 == node2) {
                res = node1;
            } else {
                break;
            }
        }
        return res;
    }

    private boolean dfs(TreeNode root, TreeNode target, Deque<TreeNode> queue) {
        if (root == target) {
            queue.add(root);
            return true;
        }
        if (root == null) {
            return false;
        }
        queue.add(root);
        if (dfs(root.left, target, queue)) {
            return true;
        }
        if (dfs(root.right, target, queue)) {
            return true;
        }
        queue.removeLast();
        return false;
    }


    public static void main(String[] args) {
        LowestCommonAncestor main = new LowestCommonAncestor();

        TreeNode root = TreeUtil.buildTree(Arrays.asList(3, 5, 1, null, null, null, null));


        System.out.println(main.lowestCommonAncestor(root, root.left, root.right).val);
    }

}
