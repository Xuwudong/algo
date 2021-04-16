package com.xwd.recursion;

import com.xwd.util.tree.TreeNode;
import com.xwd.util.tree.TreeUtil;
import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征：
//
//
// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
// 示例 1:
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
//
//
// 示例 2:
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
//
// Related Topics 树 深度优先搜索 递归
// 👍 1019 👎 0


/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-04-15 12:08
 **/
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }
        if (root.val <= left || root.val >= right) {
            return false;
        }
        return isValidBST(root.left, left, root.val) && isValidBST(root.right, root.val, right);
    }

    public static void main(String[] args) {
        IsValidBST main = new IsValidBST();
        TreeNode root = TreeUtil.buildTree(Arrays.asList(5, 4, 6, null, null, 3, 7));
        System.out.println(main.isValidBST(root));
    }
}
