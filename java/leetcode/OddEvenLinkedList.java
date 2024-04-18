package leetcode;

//문제 링크: https://leetcode.com/problems/odd-even-linked-list/description/

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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        int order = 0;

        ListNode evenCur = null;
        ListNode oddHead = null;
        ListNode oddCur = null;

        ListNode cur = head;
        while (cur != null) {
            if (order % 2 == 0) {
                if (evenCur == null) {
                    evenCur = cur;
                } else {
                    evenCur.next = cur;
                    evenCur = evenCur.next;
                }
            } else {
                if (oddHead == null) {
                    oddHead = cur;
                    oddCur = oddHead;
                } else {
                    oddCur.next = cur;
                    oddCur = oddCur.next;
                }
            }
            cur = cur.next;
            order++;
        }
        oddCur.next = null; // break cycle

        evenCur.next = oddHead;

        return head;
    }
}