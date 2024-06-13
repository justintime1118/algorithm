package leetcode;

import javax.swing.tree.TreeNode;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode cur, int depth) {
        if (cur == null)
            return depth;

        return Math.max(dfs(cur.left, depth + 1), dfs(cur.right, depth + 1));
    }
}