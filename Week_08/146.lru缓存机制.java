import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start
class LRUCache {
    /**
     * fail case
     * ["LRUCache","put","get","put","get","get"]\n[[1],[2,1],[2],[3,2],[2],[3]]
     */

    private final Map<Integer, Node> nodesMap;
    private final LinkedDeque nodesDeque;

    public LRUCache(int capacity) {
        this.nodesMap = new HashMap<>();
        this.nodesDeque = new LinkedDeque(capacity);
    }

    public int get(int key) {
        Node node = nodesMap.get(key);
        if (node == null) {
            return -1;
        } else {
            nodesDeque.moveToHead(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        Node node = nodesMap.get(key);
        if (node != null) {
            node.val = value;
            nodesDeque.moveToHead(node);
            return;
        }
        if (nodesDeque.isFull()) {
            Node removedNode = nodesDeque.removeLast();
            if (removedNode != null) {
                nodesMap.remove(removedNode.key);
            }
        }
        node = nodesDeque.addFirst(key, value);
        nodesMap.put(key, node);
    }

    private class LinkedDeque {
        private final int capacity;
        private int length;
        protected Node head;
        protected Node tail;

        protected LinkedDeque(int capacity) {
            this.capacity = capacity;
            this.length = 0;
            this.head = new Node(-1,-1, null, null);
            this.tail = new Node(-1,-1, null, null);
            this.head.next = tail;
            this.tail.pre = head;
        }

        protected Node removeLast() {
            if (isEmpty()) {
                return null;
            }
            Node temp = tail.pre;
            tail.pre = temp.pre;
            temp.pre.next = tail;
            temp.next = null;
            temp.pre = null;
            length--;
            return temp;
        }

        protected Node addFirst(int key, int val) {
            if (isFull()) {
                return null;
            }
            Node temp = head.next;
            head.next = new Node(key, val, head, temp);
            temp.pre = head.next;
            length++;
            return head.next;
        }

        protected void moveToHead(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;

            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;
        }

        protected boolean isEmpty() {
            return length == 0;
        }

        protected boolean isFull() {
            return length == capacity;
        }
    }

    protected class Node {
        protected Integer key;
        protected int val;
        protected Node pre;
        protected Node next;

        protected Node(int key, int val, Node pre, Node next) {
            this.key = key;
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

