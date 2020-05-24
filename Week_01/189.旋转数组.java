/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        /*
         * nums = "----->-->"; k =3
         * result = "-->----->";
         * reverse  "----->-->" we can get "<--<-----"
         * reverse  "<--"       we can get "--><-----"
         * reverse  "<-----"    we can get "-->----->"
         */
        int len = nums.length;
        k = k % len;
        if (k <= 0) {
            return;
        }
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
        
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp; 
            start++;
            end--;
        }
    }
}
// @lc code=end

