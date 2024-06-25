package leetcode;

//https://leetcode.com/problems/balanced-binary-tree/

import javax.swing.tree.TreeNode;

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
    boolean ans;

    public boolean isBalanced(TreeNode root) {
        ans = true;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null)
            return 0;

        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);

        if (Math.abs(leftHeight - rightHeight) > 1)
            ans = false;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
/*
 * 내려갔다가 올라오면서 자식 노드 간 깊이 차이를 검사하면 될 것 같음
 */