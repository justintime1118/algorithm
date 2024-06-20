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
    public TreeNode invertTree(TreeNode node) {
        // base condition
        if (node == null)
            return null;

        // recursive logic
        invertTree(node.left);
        invertTree(node.right);

        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        return node;
    }
}