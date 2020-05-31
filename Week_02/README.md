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