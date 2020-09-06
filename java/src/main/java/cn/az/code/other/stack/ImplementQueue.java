package cn.az.code.other.stack;

import java.util.Stack;

/**
 * @author az
 * @since 09/06/20
 */
public class ImplementQueue {

    private final Stack<Integer> stack;
    private final Stack<Integer> queue;
    private int size;

    public ImplementQueue() {
        stack = new Stack<>();
        queue = new Stack<>();
    }

    public void push(int num) {
        size++;
        stack.push(num);
    }

    public int peek() {
        if (queue.size() <= 0) {
            traverse();
        }
        return queue.peek();
    }

    public int pop() {
        if (size <= 0) {
            throw new RuntimeException("empty queue");
        }
        if (queue.size() <= 0) {
            traverse();
        }
        return queue.pop();
    }


    private void traverse() {
        while (!stack.empty()) {
            queue.push(stack.pop());
        }
    }
}
