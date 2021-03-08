package com.xwd.util.tree;

import java.util.*;

/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-03-03 11:40
 **/
public class TreeUtil {

    public static TreeNode buildTree(List<Integer> nums) {
        if (nums.size() == 0) {
            return null;
        }
        return createBinaryTree(nums, 0);
    }

    private static TreeNode createBinaryTree(List<Integer> nums, int index) {
        if (index >= nums.size()) {
            return null;
        } else {
            Integer value = nums.get(index);
            if (value == null) {
                return null;
            }
            TreeNode node = new TreeNode(value);
            node.left = createBinaryTree(nums, 2 * index + 1);
            node.right = createBinaryTree(nums, 2 * index + 2);
            return node;
        }
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 3, 2, null, 4, 5, null);
        TreeNode root = buildTree(nums);
        print(root);
    }

    public static List<Integer> leverOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return res;
    }

    public static List<Integer> leverOrderWithNull(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res.add(null);
            } else {
                res.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return res;
    }

    public static void print(TreeNode root) {
        List<Integer> res = leverOrderWithNull(root);
        for (Integer i : res) {
            if (i == null) {
                System.out.print("null\t");
            } else {
                System.out.print(i + "\t");
            }
        }
        System.out.println();
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
