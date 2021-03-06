package com.xwd.recursion;

import com.xwd.util.tree.TreeNode;

/**
 * 面试题 17.12. BiNode
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 *
 * 返回转换后的单向链表的头节点。
 *
 * 注意：本题相对原题稍作改动
 *
 *
 *
 * 示例：
 *
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 */
public class ConvertBiNode {
    /**
     * pre 需要定义为实例变量，不能传到数组中
     */
    private TreeNode pre = new TreeNode();

    public TreeNode convertBiNode(TreeNode root) {
        TreeNode res = pre;
        inorder(root);
        return res.right;
    }


    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        pre.right = node;
        pre = node;

        // 这一步必须有
        node.left = null;
        inorder(node.right);
    }
}
