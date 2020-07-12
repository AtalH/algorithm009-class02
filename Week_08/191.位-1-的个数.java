/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        //Integer.bitCount(n);
        int result = 0;
        while(n != 0) {
            result++;
            // if n = 1100 then n-1 = 1011
            n = n&(n-1);
        }
        return result;
    }
}
// @lc code=end

