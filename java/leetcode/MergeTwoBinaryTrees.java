package leetcode;

import javax.swing.tree.TreeNode;

// https://leetcode.com/problems/merge-two-binary-trees/description/

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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return null;
        if (root1 != null && root2 == null)
            return root1;
        if (root1 == null && root2 != null)
            return root2;

        TreeNode newRoot = new TreeNode(
                root1.val + root2.val,
                mergeTrees(root1.left, root2.left),
                mergeTrees(root1.right, root2.right));
        return newRoot;
    }
}
/*
 * 가짓수
 * overlapped -> value 합, 재귀로 더 들어감
 * not overlapped -> null 아닌 녀석이 해당 위치로 들어가고 더 이상 깊게 안들어가도 됨
 */