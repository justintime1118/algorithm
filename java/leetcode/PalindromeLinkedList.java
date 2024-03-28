package leetcode;

import java.util.ArrayList;
import java.util.List;

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
    public boolean isPalindrome(ListNode head) {
        // ArrayList에 옮겨담기
        List<Integer> arrlst = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            arrlst.add(cur.val);
            cur = cur.next;
        }
        // 오버로딩 메서드 호출
        return isPalindrome(arrlst);
    }

    public boolean isPalindrome(List<Integer> lst) {
        // 양끝에서 투포인터로 팰린드롬 여부 확인
        int left = 0;
        int right = lst.size() - 1;
        while (left < right) {
            if (lst.get(left).equals(lst.get(right))) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}