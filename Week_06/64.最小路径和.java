/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = grid.length-1; i >= 0; i--) {
            for (int j = grid[i].length-1; j >= 0; j--) {
                // dp 存储着原来一行的 minPath 结果
                // dp[j+1] 已经在上一个循环中更新为本行的右边一格的结果
                // dp[j] 未计算前就是下方一格的结果，计算后就是当前行了
                if(i < grid.length-1 && j < grid[i].length-1) {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j+1]);
                } else if (i == grid.length-1 && j < grid[i].length-1) {
                    dp[j] = grid[i][j] + dp[j+1];
                } else if(i < grid.length-1 && j == grid[i].length-1) {
                    dp[j] = grid[i][j] + dp[j];
                } else {
                    dp[j] = grid[i][j];
                }
            }
        }
        return dp[0];
    }
}
// @lc code=end

