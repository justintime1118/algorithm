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

        if (node.left != null && node.val == node.left.val)
            left += 1;
        else
            left = 0;
        if (node.right != null && node.val == node.right.val)
            right += 1;
        else
            right = 0;

        ans = Math.max(ans, left + right);

        return Math.max(left, right);
    }
}