package com.xwd.stack;

import com.xwd.util.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回锯齿形层序遍历如下：
//
//
//[
//  [3],
//  [20,9],
//  [15,7]
//]
//
// Related Topics 栈 树 广度优先搜索
// 👍 420 👎 0

/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-03-30 12:24
 **/
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();

        if (root == null) {
            return res;
        }
        boolean fromLeft = true;
        queue.offer(root);
        while (!queue.isEmpty()) {
            Deque<Integer> deque = new LinkedList<>();
            int currentLevelSize = queue.size();

            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();

                if (fromLeft) {
                    deque.addLast(node.val);
                } else {
                    deque.addFirst(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }


            fromLeft = !fromLeft;
            res.add(new LinkedList<>(deque));
        }
        return res;
    }
}
