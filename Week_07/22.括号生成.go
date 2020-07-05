/*
 * @lc app=leetcode.cn id=22 lang=golang
 *
 * [22] 括号生成
 */

// @lc code=start
func generateParenthesis(n int) []string {
	if n <= 0 {
		return []string{}
	}
	result := generate(n, "", make([]string, 0), 0, 0)
	return result
}

func generate(n int, temp string, result []string, left int, right int) []string  {
	if left == n && right == n {
		return append(result, temp)
	}
	if left < n {
		result = generate(n, temp+"(", result, left+1, right);
	}
	if left > right {
		result = generate(n, temp+")", result, left, right+1)
	}
	return result
}
// @lc code=end

