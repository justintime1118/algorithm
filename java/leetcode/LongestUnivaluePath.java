package leetcode;

import javax.swing.tree.TreeNode;

//https://leetcode.com/problems/longest-univalue-path/

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
    int ans;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node) {
        // base condition
        if (node == null)
            return 0;

        // recursive logic
        int left = dfs(node.left);
        int right = dfs(node.right);

        int maxLen = 0;
        // 양쪽 자식노드 모두 univalue이면 maxLen 갱신
        if (node.left != null && node.val == node.left.val
                && node.right != null && node.val == node.right.val) {
            maxLen += left + right + 2;
        }

        int leftDepth = 0;
        int rightDepth = 0;
        // 양쪽 자식노드에 대해 각각 univalue이면 depth 갱신
        if (node.left != null && node.val == node.left.val)
            leftDepth = left + 1;
        if (node.right != null && node.val == node.right.val)
            rightDepth = right + 1;

        int maxDepth = Math.max(leftDepth, rightDepth);

        // 현재 노드가 만들어 낼 수 있는 가장 긴 경로를 ans에 비교 반영
        ans = Math.max(ans, Math.max(maxLen, maxDepth));

        return maxDepth;

    }
}