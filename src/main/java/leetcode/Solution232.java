package leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * <pre>
 *     https://leetcode.com/problems/implement-queue-using-stacks/
 *    232. Implement Queue using Stacks
 *    </pre>
 */
public class Solution232 {

    @Test
    public void test() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.err.println(queue.peek());
        // returns 1
        System.err.println(queue.pop());
        // returns 1
        System.err.println(queue.empty());
        // returns false
    }

    class MyQueue {
        private Stack<Integer> first = new Stack<>();
        private Stack<Integer> second = new Stack<>();
        /**
         * true ：exist in first
         * false : exist in second
         */
        private boolean flag = true;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {

        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            if (!flag) {
                while (!second.isEmpty()) {
                    first.push(second.pop());
                }
            }
            flag = true;
            first.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (flag) {
                while (!first.isEmpty()) {
                    second.push(first.pop());
                }
            }
            if (second.isEmpty()) {
                throw new NullPointerException();
            }
            flag = false;
            return second.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (flag) {
                while (!first.isEmpty()) {
                    second.push(first.pop());
                }
            }
            if (second.isEmpty()) {
                throw new NullPointerException();
            }
            flag = false;
            return second.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return flag ? first.isEmpty() : second.isEmpty();
        }
    }
}
