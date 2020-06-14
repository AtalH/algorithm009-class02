/*
 * @lc app=leetcode.cn id=860 lang=golang
 *
 * [860] 柠檬水找零
 */

// @lc code=start
func lemonadeChange(bills []int) bool {
	// 注意面值问题
	five, ten := 0, 0
	for _, bill := range bills {
		if bill == 5 {
			five++
		} else if bill == 10 {
			five--
			ten++
		} else if ten > 0{ // bill == 20 & ten > 0
			ten--
			five--
		} else { // bill == 20 & ten < 0
			five -= 3
		}
		if (five < 0) { // ten < 0 will not happen
			return false
		}
	}
	return true
}
// @lc code=end

