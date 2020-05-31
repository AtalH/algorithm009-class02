/*
 * @lc app=leetcode.cn id=144 lang=golang
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func preorderTraversal(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}
	result := make([]int, 0)
	result = traversal(root, result)
	return result
}

func traversal(node *TreeNode, result []int) []int {
	if (node == nil) {
		return result
	}
	result = append(result, node.Val)
	result = traversal(node.Left, result)
	result = traversal(node.Right, result)
	return result
}
// @lc code=end

