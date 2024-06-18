package leetcode;

//https://leetcode.com/problems/diameter-of-binary-tree/

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
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);

        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null)
            return -1;

        int left = dfs(node.left);
        int right = dfs(node.right);

        ans = Math.max(ans, left + right + 2);

        return Math.max(left, right) + 1;
    }
}
/*
 * (왼쪽 자식 최대 깊이 + 오른쪽 자식 최대 깊이) => 특정 부모 노드 기준, 최장 경로 길이가 됨
 * 모든 노드를 기준으로 최장 경로 길이를 계산하며 직경을 갱신해주면 끝
 */