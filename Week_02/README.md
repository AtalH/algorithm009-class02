# 学习笔记

## HashMap

- 内部存储的是 Node 节点，Node 包含了属性：key，value 和 key 的 hash 值
  - 第一种 Node 是 Map.Entry 接口，以数组形式存放，Node 有一个 Next 引用，类似于单向链表的节点，用于解决 hash 冲突
  - 当一个 Node 的 Next 链长达到阈值 8 之后，会将 Node 改为 TreeNode，继承自 LinkedHashMap.Entry，是一个红黑树

- get(key) 返回 null 时，不能说明 map 中不存在 key 这个映射，因为可能 key 的 value 就是 null，可以使用 contains(key) 方法来区分
- put(key, value) 方法，如果 key 之前有 value，会返回这个 value
- 而 putIfAbsent(key, value) 方法会判断，如果 key 之前没有 value 才会执行 put 操作
- put 操作，通过 key 的 hash 值和容量值做与运算得到新 Node 在数组中的下标，如果这个下标的元素 Node 之前不存在，就成功的 put，如果这个下标的元素 Node 已存在，并且 key 不相等，就产生 hash 冲突。
- hash 冲突时，会将冲突的 Node 放到之前的 Node 的 Next 引用，当这个 Next 引用超过阈值 8 之后，就会将 Node 转换为 TreeNode
- 默认初始容量是 16，负载因子 0.75，当 size 达到 12 = 16 * 0.75 时，就会进行 2 倍扩容 resize()
- resize() 会创建一个新的 Node 数组（hash table），需要 rehash 过程，rehash 就是重新计算一个 Node 节点在新数组中的下标，计算方法是用 Node 节点的 hash 值和新容量值做与运算： e.hash & (newCap - 1)

LinkedHashMap

- 继承了 HashMap，相较于 HashMap 的特点是，HashMap 的元素是无序的，而 LinkedHashMap 虽然也是使用数组存储节点，但是节点有 previous 和 next 引用，相当于使用了双向链表，存储了元素之间的顺序，所以遍历时的元素与插入的顺序相同
-  put 方法之间使用了 HashMap 的 put 方法

### HashSet

- 使用了 HashMap 来存储元素，将元素作为 key，固定值（一个 Object 对象）最为 value 存入 HashMap 内，保证内部元素的唯一性

### LinkedHashSet

- 内部使用的是 LinkedHashMap

## 树

- 概念
  - 子节点
  - 父节点
  - 兄弟节点
  - 子树
  - 层数
- 二叉树
  - 子节点最多有 2 个
  - 前序遍历 pre order traversal
  - 中序遍历 in order traversal
  - 后续遍历 post order traversal
- 二叉搜索树
  - 根节点比左子树所有节点都小
  - 根节点比右子树所有节点都大
  - 任一子树也二叉搜索树
  - 空树也是二叉搜索树
  - 前序遍历结果是一个递增数列
- 完全二叉树
  - 除了叶子节点，其他节点都有 2 个子节点

## 堆

- 堆是一个接口，不限制具体实现方法，它是指可以迅速找到一堆数的最大值或最小值的数据结构
- 将根节点作为最大值的叫大顶堆或大根堆，根节点最小的堆叫作小顶堆或小根堆
- 常见的实现有
  - 二叉堆
    - 使用完全二叉树实现
    - 任一节点都比其子节点大
  - 斐波那契堆
  - 等等
- 二叉堆是一种堆的比较容易实现形式，所以常见，但不是效率最高的实现，java 里的是 priority queue。斐波那契堆就是效率更高的实现。
- 方法
  - findMax 或 findMin O(1)
  - deleteMax 或 deleteMin O(logn)
    - 将堆尾元素放到堆顶
    - heapifydown：新的堆顶元素不断与左右子节点比较，如果有子节点都比自己大，就跟较大的子节点互换位置
  - insert O(logn) 或 O(1)
    - 插入的新元素放到堆的尾部
    - heapifyup：新元素不断的与父节点比较，如果比父节点大，就互换位置
- 二叉堆能够通过一个数组存储
  - 第 0 个元素是根节点
  - 第 i 个节点的左子节点的下标是 2*i + 1
  - 第 i 个节点的右子节点的下标是 2*i + 2
  - 第 i 个节点的父节点的下标是 floor((i-1)/2)

## 图

- 有节点和边组成
  - vertex 节点
  - edge 边
- 有向、无向
- 权重
- 度、出度、入度
- 表示
  - 邻接矩阵
  - 邻接表
- 常见算法
  - DFS
  - BFS
  - 连通图个数：[ https://leetcode-cn.com/problems/number-of-islands/](https://leetcode-cn.com/problems/number-of-islands/)
  - 拓扑排序（Topological Sorting）：[ https://zhuanlan.zhihu.com/p/34871092](https://zhuanlan.zhihu.com/p/34871092)
  - 最短路径（Shortest Path）：Dijkstra https://www.bilibili.com/video/av25829980?from=search&seid=13391343514095937158
  - 最小生成树（Minimum Spanning Tree）：[ https://www.bilibili.com/video/av84820276?from=search&seid=17476598104352152051](https://www.bilibili.com/video/av84820276?from=search&seid=17476598104352152051)
- 遍历时记得存储已经访问过的节点，否则有环的话会死循环