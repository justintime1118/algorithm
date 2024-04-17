package leetcode;

//문제링크: https://leetcode.com/problems/swap-nodes-in-pairs/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode node) {
        // base condition
        if (node == null || node.next == null) {
            return node;
        }

        // recursive logic
        ListNode first = node.next;
        node.next = swapPairs(node.next.next);
        first.next = node;
        return first;
    }
}