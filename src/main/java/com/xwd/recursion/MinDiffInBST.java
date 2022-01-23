package com.xwd.recursion;

import com.xwd.util.tree.TreeNode;

//给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
//
//
//
// 示例：
//
// 输入: root = [4,2,6,1,3,null,null]
//输出: 1
//解释:
//注意，root是树节点对象(TreeNode object)，而不是数组。
//
//给定的树 [4,2,6,1,3,null,null] 可表示为下图:
//
//          4
//        /   \
//      2      6
//     / \
//    1   3
//
//最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
//
//
//
// 注意：
//
//
// 二叉树的大小范围在 2 到 100。
// 二叉树总是有效的，每个节点的值都是整数，且不重复。
// 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
//相同
//
// Related Topics 树 深度优先搜索 递归
// 👍 112 👎 0


/**
 * @program: algo
 * @description: 783
 * @author: xuwudong
 * @create: 2021-03-05 15:47
 **/
public class MinDiffInBST {

    private int min = Integer.MAX_VALUE;

    private Integer pre = null;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return min;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (pre != null) {
            min = Math.min(min, Math.abs(node.val - pre));
        }
        pre = node.val;
        inorder(node.right);
    }
}
