import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }
        Map<String, List<String>> anagMap = new HashMap<>();
        for (String str : strs) {
            char[] anag = str.toCharArray();
             Arrays.sort(anag);
            String key = String.valueOf(anag);
            List<String> anagList = anagMap.computeIfAbsent(key, k ->new ArrayList<>());
            anagList.add(str);
        }
        return new ArrayList<>(anagMap.values());
    }
}
// @lc code=end

