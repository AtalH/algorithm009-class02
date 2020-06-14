# 学习笔记

- 深度优先搜索和广度优先搜索，是图结构的遍历的两种方式，由于树是图的一种特例，因此也使用于树的遍历

## DFS depth first search 深度优先搜索

- 使用递归的代码模板

  ```go
  visited := make(map[Node]string, 0)
  
  func dfs(node Node, visited map[int]Node) {
      if visited[Node] == "visited" {
          return
      }
      visited[node] = "visited"
      
      // process current node
      ...
      
      for _, next := range node.Children {
          if _, ok := visited[Node]; !ok {
              dfs(next, visited)
          }
      }
  }
  ```

- 使用非递归的代码模板

  - 使用栈结构，后放入的当前节点的相邻节点先处理，而不是先处理完父节点的相邻节点，达到深度优先策略

  ```go
  func dfs(tree Tree) []int {
      if (tree.Root == nill) {
          return []int{}
      }
      visited, stack := make(map[Node]string, 0), createStack()
      stack.push(tree.Root)
      for len(stack) > 0 {
          node := stack.pop()
          visited[node] = "visited"
          
          process(node)
          
          nodes := getRelatedNodes(node)
          stack.push(nodes)
      }
      
      // other process
  }
  ```

- BFS breadth first search 广度优先搜索

- 代码模板

  - 使用队列结构，先放入的节点先处理，因此会先处理完一个节点的所有相邻节点，再处理相邻节点的相邻节点，达到广度优先策略

  ```go
  func bfs(graph Graph, start Node, end Node) {
      visited, queue := make(map[Node]string, 0), createQueue()
      queue.push([]Node{start})
      for len(queue) > 0 {
          node := queue.pop()
          visited[node] = "visited"
          
          process(node)
          
          nodes := getRelatedNodes(node)
          queue.push(nodes)
      }
      
      // other process
  }
  ```

## 贪心算法 Greedy

- 当一个问题可以分解为多个子问题，并且每个子问题的最优解的集合，能够构成全局最优解时，求解每个子问题就优先求解子问题的最优解，就是贪心算法。
- 贪心算法不能回退状态，这是与动态规划算法的区别，动态规划就是回溯加贪心算法
- 能应用贪心算法求得最优解的问题不多，需要判断好一个问题能不能使用贪心算法

## 二分查找 binary search

- 能够使用二分查找的 3 个前提条件

  - 数据是已经排好序的，即数据是单调递增或递减的
  - 数据量存在上下界
  - 能够通过索引访问元素

- 代码模板

  - 注意事项：计算中值时注意整型溢出问题

  ```go
  func binarySearch(array []int, target int) int {
      left, right := 0, len(array) - 1
      for left<= right {
          mid := left/2 + right/2
          if array[mid] == target {
              return mid
          } else if array[mid] > target {
              right = mid - 1
          } else {
              left = mid + 1
          }
      }
      return -1;
  }
  ```

- 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

  - 思路：当一个元素比前一个元素大并且也比后一个元素大时，就找到了无序的地方

    ```go
    package main
    
    import "fmt"
    
    func unsortedIndex(array []int) int {
    	count := len(array)
    	if count < 2 {
    		return 0
    	} else if count == 2 && array[0] > array[1] {
    		return 1
    	}
    	left, right := 0, count-1
    	for left <= right {
    		mid := left/2 + right/2
    		if array[mid] > array[mid-1] && array[mid] > array[mid+1] {
    			return mid + 1
    		} else if array[mid] > array[mid-1] {
    			left = mid + 1
    		} else {
    			right = mid - 1
    		}
    	}
    	return 0
    }
    
    func main() {
    	// test case
    	// array := []int{0, 3, 2}
    	// array := []int{3, 2}
    	array := []int{4, 5, 6, 7, 0, 1, 2}
    	// array := []int{0, 1, 2, 3, 7, 6, 5}
    	// array := []int{0, 1, 2, 9, 8, 7, 6, 5, 4, 3, 2, 1}
    	i := unsortedIndex(array)
    	fmt.Println(i)
    }
    ```

- 快速开根号
  - 牛顿迭代
  - https://www.beyond3d.com/content/articles/8/

