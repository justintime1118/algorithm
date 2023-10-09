# https://leetcode.com/problems/group-anagrams/description/

from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = defaultdict(list)

        for word in strs:
            # 정렬한 값을 키로하여 딕셔너리에 추가
            anagrams[''.join(sorted(word))].append(word)
        return list(anagrams.values())
        
        '''
        sorted_strs = [''.join(sorted(list(word))) for word in strs]

        sorted_dict = dict()
        for idx, sorted_str in enumerate(sorted_strs):
            if sorted_str in sorted_dict:
                sorted_dict[sorted_str].append(idx)
            else:
                sorted_dict[sorted_str] = [idx]
        
        ret = []
        for index_list in sorted_dict.values():
            ret.append([strs[index] for index in index_list])
        return ret
        '''