package com.xwd.meeting;

import com.xwd.util.tree.TreeNode;

import java.util.Stack;

/**
 * @Author LXT
 * @create 2021/6/1 16:33
 */
public class Toutiao {

    public TreeNode buildTree(int[] arr) {
        TreeNode root = new TreeNode(arr[0]);
        buildTree(root, arr, 0);
        return root;
    }

    private void buildTree(TreeNode node, int[] arr, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (left < arr.length && arr[left] != -1) {
            TreeNode leftNode = new TreeNode(arr[left]);
            node.left = leftNode;
            buildTree(node.left, arr, left);
        }
        if (right < arr.length && arr[right] != -1) {
            TreeNode rightNode = new TreeNode(arr[right]);
            node.right = rightNode;
            buildTree(rightNode, arr, right);
        }
    }

    public void inOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);

        }
        TreeNode cur = stack.peek();
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                while (cur.left != null) {
                    stack.push(cur.left);
                    cur = cur.left;
                }
            }
            TreeNode node = stack.pop();
            System.out.print(node.val + "  ");
            if (node.right != null) {
                stack.push(node.right);
            }
            cur = node.right;
        }
    }

    public void inOrder2(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        if (arr.length > 0) {
            stack.push(0);
        }
        Integer index = stack.peek();
        while (index != null || !stack.isEmpty()) {
            if (index != null) {
                while (2 * index + 1 < arr.length && arr[2 * index + 1] != -1) {
                    stack.push(2 * index + 1);
                    index = 2 * index + 1;
                }
            }
            Integer curIndex = stack.pop();
            System.out.print(arr[curIndex] + "  ");
            if (2 * curIndex + 2 < arr.length && arr[2 * curIndex + 2] != -1) {
                stack.push(2 * curIndex + 2);
                index = 2 * curIndex + 2;
            } else {
                index = null;
            }
        }
    }

    public void inorder(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        System.out.print(node.val + "  ");
        dfs(node.right);
    }

    public static void main(String[] args) {
        Toutiao toutiao = new Toutiao();
//        TreeNode root = toutiao.buildTree(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14});
        toutiao.inOrder2(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14});
        System.out.println();
        toutiao.inOrder2(new int[]{0, 1, 2, 3, 4, -1, -1, -1, 8, 9});

//        toutiao.inorder(root);
//        System.out.println();
//        toutiao.inOrder2(root);
//        System.out.println();
//        System.out.println();
//        toutiao.inorder(root);
//        System.out.println();
//        toutiao.inOrder2(root);
    }
}
