/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 
            || obstacleGrid[0].length == 0) {
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        boolean meetObstacle = false;
        for (int i = 0; i < row; i++) {
            if(obstacleGrid[i][0] == 1 || meetObstacle) {
                dp[i][0] = 0;
                meetObstacle = true;
            } else {
                dp[i][0] = 1;
            }
        }
        meetObstacle = false;
        for (int j = 0; j < col; j++) {
            if(obstacleGrid[0][j] == 1 || meetObstacle) {
                dp[0][j] = 0;
                meetObstacle = true;
            } else {
                dp[0][j] = 1;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[row-1][col-1];
    }
}
// @lc code=end

