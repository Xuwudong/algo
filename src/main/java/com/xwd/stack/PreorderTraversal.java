package com.xwd.stack;

import com.xwd.util.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
//
//
//
// 示例 1：
//
//
//输入：root = [1,null,2,3]
//输出：[1,2,3]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [1]
//输出：[1]
//
//
// 示例 4：
//
//
//输入：root = [1,2]
//输出：[1,2]
//
//
// 示例 5：
//
//
//输入：root = [1,null,2]
//输出：[1,2]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树
// 👍 547 👎 0

/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-03-29 20:59
 **/
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        java.util.Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop().right;
        }

        return res;
    }

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            res.add(root.val);
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            preorderTraversal(stack.pop().right);
        }
        return res;
    }
}
