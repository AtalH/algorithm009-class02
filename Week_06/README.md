# 学习笔记

- 动态规划

  - dynamic programming
  - Simplifying a complicated problem by breaking it down into simpler subproblems, in a recursive manner
  - 就是分治+最优子结构 Optimal substructure
  - 动态规划的问题往往是求解一个最优解，最大值，最少方法...
  - 中间需要存储每一步的最优解，这个称为 dp 状态数组或最优子结构
  - 每一步中，淘汰次优解，得到最优解的公式或方程，称为 dp 方程或状态转移方程

- 自底向上 Bottom up

  - 爬楼梯问题的递归+记忆化搜索的解决方式称为自顶向下式，即当求爬到第 n 级时，先求爬到 n -1 和 n -2 级

    ```go
    fib(n int, memo []int) int {
        if(memp[n] == 0) {
            memo[n] = fib[n-1] + fib[n-2]
        }
        return memo[n]
    }
    ```

    

  - 而使用自底向上方式，是从第 1 级和第 2 级往上爬，递推到第 n 级。

    - 其中 dp[i] = dp[i-1] + dp[i-2] 就是状态转移方程

    ```go
    dp := make([]int, n)
    dp[0], dp[1] = 0, 1
    for i:= 2; i <= n; i++ {
        dp[i] = dp[i-1] + dp[i-2]
    }
    return dp[n]
    ```

    