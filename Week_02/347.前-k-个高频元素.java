import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequentMap = new HashMap<>();
        for (int n : nums) {
            Integer f = frequentMap.get(n);
            if (f == null) {
                f = 0;
            }
            frequentMap.put(n, ++f);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue()
            );
        for (Map.Entry<Integer, Integer> entry: frequentMap.entrySet()) {
            if (pq.size() < k) {
                pq.add(entry);
            } else if (entry.getValue() > pq.peek().getValue()){
                pq.remove();
                pq.add(entry);
            }
        }
        int[] result = new int[k];
        int i = 0;
        for (Map.Entry<Integer,Integer> entry : pq) {
            result[i] = entry.getKey();
            i++;
        }
        return result;
    }
}
// @lc code=end

