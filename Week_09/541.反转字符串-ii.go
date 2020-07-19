/*
 * @lc app=leetcode.cn id=541 lang=golang
 *
 * [541] 反转字符串 II
 */

// @lc code=start
func reverseStr(s string, k int) string {
	len := len(s)
	if len <= 1 || k <= 0 {
		return s
	}
	sl := []byte(s)
	for i := 0; i < len; i += 2*k {
		m, n := i, len - 1
		if len - 1 > i + k - 1 {
			n = i + k - 1
		}
		for m < n {
			sl[m], sl[n] = sl[n], sl[m]
			m++
			n--
		}
	}
	return string(sl)
}
// @lc code=end

