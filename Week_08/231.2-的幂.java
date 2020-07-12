/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        // only one bit 1
        if(n > 0) {
            return (n&(n-1)) == 0;
        } else if(n < 0) {
            long x = (long)n;
            return (x&(x-1)) == 0;
        } else {
            return false;
        }
    }
}
// @lc code=end

