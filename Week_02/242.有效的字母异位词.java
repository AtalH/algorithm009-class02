import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int slen = s==null ? 0 : s.length();
        int tlen = t==null ? 0 : t.length();

        if (slen == 0 && tlen == 0) {
            return true;
        } else if (slen != tlen) {
            return false;
        }
        // simple hash table
        int[] countMap = new int[26];
        for (int i = 0; i < slen; i++) {
            countMap[s.charAt(i) - 'a']++;
            countMap[t.charAt(i) - 'a']--;
        }
        for (int count : countMap) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

