/*
 * @lc app=leetcode.cn id=283 lang=golang
 *
 * [283] 移动零
 */

// @lc code=start
func moveZeroes(nums []int) {
	size := len(nums)
	// slow index
	lastNotZeroIndex := 0
	for i := 0; i < size; i++ {
		if nums[i] != 0 {
			nums[lastNotZeroIndex], nums[i] = nums[i], nums[lastNotZeroIndex]
			lastNotZeroIndex++
		}
	}
}

// @lc code=end
