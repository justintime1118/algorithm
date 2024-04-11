package leetcode;

import java.util.LinkedList;

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
    // 스택을 활용한 풀이
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;

        LinkedList<ListNode> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode cur = stack.pop();
        head = cur;
        while (stack.size() > 0) {
            cur.next = stack.pop();
            cur = cur.next;
        }
        cur.next = null;

        return head;
    }
}