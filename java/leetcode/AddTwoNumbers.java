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

        // 자릿수 합이 9보다 큰지를 기록하는 플래그 변수
        boolean gt9 = false;
        ListNode cur = new ListNode();
        ListNode head = cur;
        while (true) {
            // 이전 자릿수에서 넘어온 값이 있다면 반영
            if (gt9 == true) {
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

            // 현 자릿수 합이 9보다 큰지 기록하고,
            // 만약 9보다 크다면 1의 자리만 남김
            if (cur.val > 9) {
                gt9 = true;
                cur.val %= 10;
            } else {
                gt9 = false;
            }

            if (l1 != null || l2 != null) {
                cur.next = new ListNode();
                cur = cur.next;
            } else
                break;
        }

        // 마지막 자리 처리
        // 이전 자릿수 합이 9보다 컸을 경우에만 새로운 노드를 만들고 val에 1을 넣어줌
        if (gt9 == true) {
            cur.next = new ListNode();
            cur.next.val = 1;
        }
        return head;
    }
}