/*
 * @lc app=leetcode.cn id=429 lang=golang
 *
 * [429] N叉树的层序遍历
 */

// @lc code=start
/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */

 func levelOrder(root *Node) [][]int {
    if root == nil {
		return [][]int{}
	}
	result := make([][]int, 1)
	result[0] = append(result[0], root.Val)
	result = levelTraversal(root.Children, result)
	return result
}

func levelTraversal(nodes []*Node, result [][]int) [][]int {
    if (len(nodes) == 0) {
        return result
    }
	levelVal := make([]int, 0)
	children := make([]*Node, 0)
	for _, node := range nodes {
		levelVal = append(levelVal, node.Val)
		children = append(children, node.Children...)
	}
	result = append(result, levelVal)
	result = levelTraversal(children, result)
	return result
}
// @lc code=end

