package com.xwd.recursion;

import com.xwd.util.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

//给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
//
//
//
// 示例 ：
//
// 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
//
//       5
//      / \
//    3    6
//   / \    \
//  2   4    8
// /        / \
//1        7   9
//
//输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
//
// 1
//  \
//   2
//    \
//     3
//      \
//       4
//        \
//         5
//          \
//           6
//            \
//             7
//              \
//               8
//                \
//                 9
//
//
//
// 提示：
//
//
// 给定树中的结点数介于 1 和 100 之间。
// 每个结点都有一个从 0 到 1000 范围内的唯一整数值。
//
// Related Topics 树 深度优先搜索 递归
// 👍 135 👎 0


/**
 * @program: algo
 * @description: 897
 * @author: xuwudong
 * @create: 2021-03-05 16:45
 **/
public class IncreasingBST {
    private TreeNode pre = new TreeNode();

    public TreeNode increasingBST(TreeNode root) {
        TreeNode res = pre;

        inorder(root, pre);
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        for (Integer val : list) {
            pre.right = new TreeNode(val);
            pre = pre.right;
        }

        return res.right;
    }


    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }


    /**
     * 错误的写法
     *
     * @param root
     * @return
     */
    public TreeNode increasingBST2(TreeNode root) {
        TreeNode res = pre;

        inorder(root, pre);

        return res.right;
    }


    /**
     * 错误的写法，不能传个指针进行中序遍历
     *
     * @param node
     * @param pre
     */
    private void inorder(TreeNode node, TreeNode pre) {
        if (node == null) {
            return;
        }
        inorder(node.left, pre);
        pre.right = new TreeNode(node.val);
        pre = pre.right;
        inorder(node.right, pre);
    }
}
