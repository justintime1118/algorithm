# https://leetcode.com/problems/valid-parentheses/description/

from collections import deque

class Solution:
    def isValid(self, s: str) -> bool:
        st = deque()

        # 첫번째 원소 체크가 좀 신경쓰이는구만
        for c in s:
            if c == '(' or c == '{' or c == '[':
                st.appendleft(c)
                print('push', c)
            else:
                if len(st) > 0 and\
                    ((c == ')' and st[0] == '(')
                    or (c == ']' and st[0] == '[')
                    or (c == '}' and st[0] == '{')):
                    st.popleft()
                else:
                    return False
        
        return True if len(st) == 0 else False
