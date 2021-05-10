package com.xwd.recursion;

import com.xwd.util.tree.TreeNode;

//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
//
//
//
// 示例 :
//给定二叉树
//
//           1
//         / \
//        2   3
//       / \
//      4   5
//
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
//
//
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。
// Related Topics 树
// 👍 705 👎 0


/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-05-21 11:34
 **/
public class DiameterOfBinaryTree {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        path(root);
        return max;
    }

    private int path(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftPath = 0;
        if (node.left != null) {
            leftPath = path(node.left) + 1;
        }
        int rightPath = 0;
        if (node.right != null) {
            rightPath = path(node.right) + 1;
        }
        if (leftPath + rightPath > max) {
            max = leftPath + rightPath;
        }
        return Math.max(leftPath, rightPath);
    }
}
