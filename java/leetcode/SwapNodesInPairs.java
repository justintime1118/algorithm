package leetcode;

import java.util.LinkedList;

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
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        int size = 0;
        ListNode cur = head;
        LinkedList<ListNode> stack = new LinkedList<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        ListNode prev = null;
        // List의 길이가 홀수인 경우 처리
        if (stack.size() % 2 != 0) {
            prev = stack.pop();
        }

        ListNode adj1 = null;
        ListNode adj2 = null;
        ListNode tmp = null;
        // 1->2로 되어 있던 것을 2->1로 swap
        while (stack.size() > 0) {
            adj2 = stack.pop();
            adj1 = stack.pop();

            adj1.next = prev;
            adj2.next = adj1;
            prev = adj2;
        }

        return prev;
    }
}