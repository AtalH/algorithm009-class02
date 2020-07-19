/*
 * @lc app=leetcode.cn id=300 lang=golang
 *
 * [300] 最长上升子序列
 */

// @lc code=start
func lengthOfLIS(nums []int) int {
	n := len(nums)
	if n <= 1 {
		return n
	}
	dp := make([]int, n)
	dp[0] = 1
	max := 0
	for i := 1; i < n; i++ {
		tempMax := 0
		for j := 0; j < i; j++ {
			if nums[j] < nums[i] {
				if tempMax < dp[j] {
					tempMax = dp[j]
				}
			}
		}
		dp[i] = tempMax + 1
		if max < dp[i] {
			max = dp[i]
		}
	}
	return max
}
// @lc code=end

