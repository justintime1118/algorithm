package leetcode;

//문제링크: https://leetcode.com/problems/add-two-numbers/

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        boolean gt10 = false;
        ;
        ListNode cur = new ListNode();
        ListNode head = cur;
        while (true) {
            if (gt10 == true) {
                cur.val += 1;
            }
            if (l1 != null) {
                cur.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                cur.val += l2.val;
                l2 = l2.next;
            }

            if (cur.val > 9) {
                gt10 = true;
                cur.val %= 10;
            } else {
                gt10 = false;
            }

            if (l1 != null || l2 != null) {
                cur.next = new ListNode();
                cur = cur.next;
            } else
                break;
        }
        if (gt10 == true) {
            cur.next = new ListNode();
            cur.next.val = 1;
        }
        return head;
    }
}