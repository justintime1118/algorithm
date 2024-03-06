package leetcode;

//https://leetcode.com/problems/most-common-word/
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public String mostCommonWord(String p, String[] banned) {
        HashMap<String, Integer> wordsCntMap = new HashMap<>();
        HashSet<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        String[] words = p.replaceAll("\\W+", " ").toLowerCase().split(" ");

        for (String word : words) {
            if (!bannedSet.contains(word))
                wordsCntMap.put(word, wordsCntMap.getOrDefault(word, 0) + 1);
        }

        return Collections.max(wordsCntMap.entrySet(), Map.Entry.comparingByValue())
                .getKey();
    }
}