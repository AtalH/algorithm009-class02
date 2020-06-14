/*
 * @lc app=leetcode.cn id=122 lang=golang
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
func maxProfit(prices []int) int {
	if len(prices) == 0 {
		return 0;
	}
	// 将所有股价上升期的价格差累加即可
	maxProfit := 0
	for i := 1; i < len(prices); i++ {
		if (prices[i] > prices[i - 1]) {
			maxProfit += prices[i] - prices[i - 1]
		}
	}
	return maxProfit
}
// @lc code=end

