package leetcode;

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null || list2 == null)
            return list1 != null ? list1 : list2;

        ListNode head = new ListNode();
        ListNode cursor = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cursor.val = list1.val;
                list1 = list1.next;
            } else {
                cursor.val = list2.val;
                list2 = list2.next;
            }
            if (list1 != null && list2 != null) {
                cursor.next = new ListNode();
                cursor = cursor.next;
            }
        }

        cursor.next = list1 != null ? list1 : list2;

        return head;
    }
}
