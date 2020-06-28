/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1==null ? 0 : word1.length();
        int m = word2==null ? 0 : word2.length();
        if(m == 0 || n == 0) {
            return m + n;
        }
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < m+1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                int left = dp[i-1][j] + 1;
                int down = dp[i][j-1] + 1;
                int leftDown = dp[i-1][j-1];
                if(word1.charAt(i-1) != word2.charAt(j-1)){
                    leftDown++;
                }
                dp[i][j] = Math.min(left, Math.min(down, leftDown));
            }
        }
        return dp[n][m];
    }
}
// @lc code=end

