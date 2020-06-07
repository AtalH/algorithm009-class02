# 学习笔记

## 递归代码模板

``` go
func recursion(level int, param int) {
    // 1. terminator
    if (level > maxLevel) {
        // process result
        return;
    }
    // 2. process current level logic
    process(level, param)
    
    // 3. drill down
    recursion(level + 1, newParam)
    
    // 4. restore current level status if needed
}
```

## 递归思维要点

- 摒弃人肉递归
- 找最近重复子问题
- 使用数学归纳法，使用 n = 1, 2, 3 ... 判断出 n + 1 的递推公式

## 分治 Divide & Conquer

- 递归的一种

- 将问题分解为多个子问题

- 代码模板

  ```go
  func divideConquer(problem, param1, param2, ...) {
      // 1. terminator
      if problem == nil {
          // result process
          return;
      }
      // 2. process current level: problem divide
      data := prepareData(problem)
      subproblems := split_problem(problem, data)
      
      // 3. drill down: conquer subproblem
      subresult1 := divideConquer(subproblems[0], param1, param2, ...)
      subresult2 := divideConquer(subproblems[1], param1, param2, ...)
      subresult3 := divideConquer(subproblems[2], param1, param2, ...)
      
      // 4. merge result
      result := processResult(subresult1, subresult2, subresult3)
      
      // 5. restore current level status if needed
  }
  ```

  

## 回溯 Backtracking

- 也是递归的一种
- 采用试错的思想，分步解决一个问题，当一个分步发现走到已不可能得到正确结果时，取消上一步甚至上几步的计算结果，再走下一个分步
- 典型问题：八皇后，位运算
- 代码模板：同泛型递归

- 奇数 odd，偶数 even