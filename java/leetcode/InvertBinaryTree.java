package leetcode;

import javax.swing.tree.TreeNode;

//https://leetcode.com/problems/invert-binary-tree/description/

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
    public TreeNode invertTree(TreeNode root) {
        dfi(root);
        return root;
    }

    public void dfi(TreeNode node) {
        // base condition
        if (node == null)
            return;

        // recursive logic
        dfi(node.left);
        dfi(node.right);

        switchChildren(node);
    }

    public void switchChildren(TreeNode parent) {
        TreeNode tmp = parent.left;
        parent.left = parent.right;
        parent.right = tmp;
    }
}