/*
 * @lc app=leetcode.cn id=200 lang=golang
 *
 * [200] 岛屿数量
 */

// @lc code=start
func numIslands(grid [][]byte) int {
	result := 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			if grid[i][j] == '1' {
				result++;
				destroyIsland(grid, i, j)
			}
		}
	}
	return result
}

func destroyIsland(grid [][]byte, i int, j int) {
	if (i < 0 || i > len(grid) - 1 || j < 0 || j > len(grid[i]) - 1) {
		return
	}
	if (grid[i][j] == '1') {
		grid[i][j] = '0'
	} else {
		return
	}
	
	destroyIsland(grid, i - 1, j)
	destroyIsland(grid, i + 1, j)
	destroyIsland(grid, i, j - 1)
	destroyIsland(grid, i, j + 1)
}
// @lc code=end

