# 学习笔记

## [不同路径ii](https://leetcode-cn.com/problems/unique-paths-ii/) 的状态转移方程

```java
if(obstacleGrid[i][j] == 1) {
    dp[i][j] = 0;
} else {
    dp[i][j] = dp[i-1][j] + dp[i][j-1];
}
```

## 字符串

- java 等语言的字符串对象是不可变的，对字符进行修改会产生一个新的字符串对象
- 字符串的问题往往跟动态规划一起出现
- 字符串匹配算法
  - 暴力法 brute force
  - Rabin-Karp 算法
    - 使用 hash 进行判断
    - hash 算法的选取：换一个字符进行重新计算 hash 时，需要 O(1) 复杂度
    - hash 值不一样时，两个字符肯定不相等
    - hash 值一样时，因为有 hash 冲突问题，因此还需要完整比较一次两个字符串
  - [KMP 算法](https://www.bilibili.com/video/av11866460?from=search&seid=17425875345653862171)
    - KMP 是算法发明人的缩写
    - 如果目标字符串的各个子串存在公共前缀、后缀，那么在匹配时，暴力法是有重复匹配的问题，KMP算法就是为优化这部分重复问题而发明的
  - [Boyer-Moore 算法](https://www.ruanyifeng.com/blog/2013/05/boyer-moore_string_search_algorithm.html)
    - 实际使用更多的是 Boyer-Moore 算法，比 KMP 算法效率更高
    - 特点是从目标字符串尾部进行比较
    - 发现不匹配时，使用“坏字符规则”和“好后缀规则”，能向后跳过多个字符，再进行匹配。
  - [Sunday 算法](https://blog.csdn.net/u012505432/article/details/52210975)
    - 比 Boyer-Moore 算法效率更优一点

