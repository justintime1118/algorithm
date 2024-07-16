package leetcode;

//https://leetcode.com/problems/same-tree/?envType=problem-list-v2&envId=oizxjoit

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

    boolean ans = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        check(p, q);
        return ans;
    }

    // 전위 순회 방식으로 구조와 값 체크
    public void check(TreeNode p, TreeNode q) {
        // 이미 ans가 false인게 결정됐으면 바로 return
        if (!ans)
            return;

        // 구조 체크
        // 두 참조변수 중 하나만 null이면 둘은 다른 트리
        if ((p != null && q == null)
                || (p == null && q != null)) {
            ans = false;
            return;
        }
        // 두 참조변수 모두 null이면 재귀호출 X
        else if (p == null && q == null)
            return;

        // 값 체크
        if (p.val != q.val) {
            ans = false;
            return;
        }

        // 모든 체크를 다 통과했으면 자식노드에 대해서 재귀적으로 검사
        check(p.left, q.left);
        check(p.right, q.right);
    }
}