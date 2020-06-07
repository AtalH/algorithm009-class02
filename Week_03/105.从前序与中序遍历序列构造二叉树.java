import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    /**
     * 前序遍历
     * [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
     * 
     * 中序遍历
     * [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
     * 
     */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> inordeMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inordeMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1, inordeMap);
    }

    private TreeNode build(int[] preorder, int preL, int preR, 
                           int inL, int inR, 
                           Map<Integer, Integer> inordeMap) {
        
        if (preL > preR || inL > inR) {
            return null;
        }
        int rootVal = preorder[preL];
        TreeNode root = new TreeNode(rootVal);
        int i = inordeMap.get(rootVal);
        root.left = build(preorder, preL + 1, i - inL + preL , inL, i - 1, inordeMap);
        root.right = build(preorder, i - inL + preL + 1, preR, i + 1, inR, inordeMap);
        return root;
    }
}
// @lc code=end

