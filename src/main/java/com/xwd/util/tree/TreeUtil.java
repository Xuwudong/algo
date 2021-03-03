package com.xwd.util.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-03-03 11:40
 **/
public class TreeUtil {

    public static TreeNode buildTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return createBinaryTreeByArray(nums, 0);
    }

    private static TreeNode createBinaryTreeByArray(int[] nums, int index) {
        if (index >= nums.length) {
            return null;
        } else {
            int value = nums[index];
            TreeNode node = new TreeNode(value);
            node.left = createBinaryTreeByArray(nums, 2 * index + 1);
            node.right = createBinaryTreeByArray(nums, 2 * index + 2);
            return node;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }

}
