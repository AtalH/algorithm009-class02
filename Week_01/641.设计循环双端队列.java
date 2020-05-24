/*
 * @lc app=leetcode.cn id=641 lang=java
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
class MyCircularDeque {
    private Node head;
    private Node tail;
    private int maxSize;
    private int curSize = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        maxSize = k;
        head = new Node(0, null, null);
        tail = new Node(-1, null, null);
        head.next = tail;
        tail.pre = head;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (curSize + 1 > maxSize) {
            return false;
        }
        Node temp = head.next;
        head.next = new Node(value, head.next, head);
        temp.pre = head.next;
        curSize++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (curSize + 1 > maxSize) {
            return false;
        }
        Node temp = tail.pre;
        tail.pre = new Node(value, tail, tail.pre);
        temp.next = tail.pre;
        curSize++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (curSize == 0) {
            return false;
        }
        Node delNode = head.next;
        head.next = delNode.next;
        delNode.next.pre = head;
        delNode.next = null; // gc work
        delNode.pre = null;
        curSize--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (curSize == 0) {
            return false;
        }
        Node delNode = tail.pre;
        tail.pre = delNode.pre;
        delNode.pre.next = tail;
        delNode.next = null; // gc work
        delNode.pre = null;
        curSize--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (curSize == 0) {
            return -1;
        }
        return head.next.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (curSize == 0) {
            return -1;
        }
        return tail.pre.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return curSize == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return curSize >= maxSize;
    }

    private class Node {
        int val;
        Node next;
        Node pre;
        Node(int val, Node next, Node pre){
            this.val = val;
            this.next = next;
            this.pre = pre;
        }
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
// @lc code=end

