# https://leetcode.com/problems/group-anagrams/description/

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
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