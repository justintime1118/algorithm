# https://leetcode.com/problems/palindrome-linked-list/description/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

from collections import deque

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head is None:
            return True
        
        deq = deque()
        node = head

        while node is not None:
            deq.append(node.val)
            node = node.next
        
        while len(deq) > 1:
            if deq.popleft() != deq.pop():
                return False

        return True