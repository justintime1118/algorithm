# https://leetcode.com/problems/most-common-word/description/

import collections, re

class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        words = [word for word in re.sub('[^\w]', ' ', paragraph).lower().split() if word not in banned]
        
        return collections.Counter(words).most_common(1)[0][0]
