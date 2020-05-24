/*
 * @lc app=leetcode.cn id=1 lang=golang
 *
 * [1] 两数之和
 */

// @lc code=start
func twoSum(nums []int, target int) []int {
	l := len(nums)
	numsMap := make(map[int]int, l)
	for i := 0; i < l; i++ {
		if v, ok := numsMap[target - nums[i]]; ok {
			// if v != i, v < i will be true, cause v already in the map
			if v < i {
				return []int{v, i}
			}
		}
		numsMap[nums[i]] = i
	}
	panic("no target match")
}

// @lc code=end
