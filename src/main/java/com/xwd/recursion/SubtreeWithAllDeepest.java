package com.xwd.recursion;

import com.xwd.util.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 865. 具有所有最深节点的最小子树
 * 给定一个根为 root 的二叉树，每个节点的深度是 该节点到根的最短距离 。
 *
 * 如果一个节点在 整个树 的任意节点之间具有最大的深度，则该节点是 最深的 。
 *
 * 一个节点的 子树 是该节点加上它的所有后代的集合。
 *
 * 返回能满足 以该节点为根的子树中包含所有最深的节点 这一条件的具有最大深度的节点。
 *
 *
 *
 * 注意：本题与力扣 1123 重复：https://leetcode-cn.com/problems/lowest-common-ancestor-of-deepest-leaves/
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4]
 * 输出：[2,7,4]
 * 解释：
 * 我们返回值为 2 的节点，在图中用黄色标记。
 * 在图中用蓝色标记的是树的最深的节点。
 * 注意，节点 5、3 和 2 包含树中最深的节点，但节点 2 的子树最小，因此我们返回它。
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 解释：根节点是树中最深的节点。
 * 示例 3：
 *
 * 输入：root = [0,1,3,null,2]
 * 输出：[2]
 * 解释：树中最深的节点为 2 ，有效子树为节点 2、1 和 0 的子树，但节点 2 的子树最小。
 *
 * https://leetcode-cn.com/problems/smallest-subtree-with-all-the-deepest-nodes/solution/ju-you-suo-you-zui-shen-jie-dian-de-zui-xiao-zi-sh/
 * @Author LXT
 * @create 2021/3/7 18:34
 */
public class SubtreeWithAllDeepest {

    private Map<TreeNode, Integer> depth = new HashMap<>();
    private int maxDepth = -1;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        TreeNode parent = null;
        depth.put(parent, 0);
        dfs(root, parent);
        for (Integer d : depth.values()) {
            maxDepth = d > maxDepth ? d : maxDepth;
        }
        return answer(root);
    }

    private void dfs(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        depth.put(node, depth.get(parent) + 1);
        dfs(node.left, node);
        dfs(node.right, node);
    }

    private TreeNode answer(TreeNode node) {
        if (node == null || depth.get(node) == maxDepth) {
            return node;
        }
        TreeNode l = answer(node.left);
        TreeNode r = answer(node.right);
        if (l != null && r != null) {
            return node;
        } else if (l != null) {
            return l;
        } else if (r != null) {
            return r;
        } else {
            return null;
        }
    }

    public TreeNode subtreeWithAllDeepest2(TreeNode root) {
        return dfs(root).node;
    }

    private Result dfs(TreeNode root) {
        if (root == null) {
            return new Result(root, 0);
        }
        Result l = dfs(root.left);
        Result r = dfs(root.right);
        if (l.depth > r.depth) {
            return new Result(l.node, l.depth + 1);
        } else if (l.depth < r.depth) {
            return new Result(r.node, r.depth + 1);
        } else {
            return new Result(root, l.depth + 1);
        }
    }
}

class Result {
    TreeNode node;
    int depth;

    public Result(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}
