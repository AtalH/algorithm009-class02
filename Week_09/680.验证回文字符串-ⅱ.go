package main

/*
 * @lc app=leetcode.cn id=680 lang=golang
 *
 * [680] 验证回文字符串 Ⅱ
 */

// @lc code=start
func validPalindrome(s string) bool {
	n := len(s)
	if n <= 1 {
		return true
	}
	l, r := 0, n-1
	for l < r {
		if s[l] != s[r] {
			return doValidate(s, l+1, r) || doValidate(s, l, r-1)
		}
		l++
		r--
	}
	return true
}

func doValidate(s string, l int, r int) bool {
	for l < r {
		if s[l] != s[r] {
			return false
		}
		l++
		r--
	}
	return true
}

// @lc code=end
