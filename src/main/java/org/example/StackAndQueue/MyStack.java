package org.example.StackAndQueue;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.offer(x);
        while(!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        queue1.clear();
        queue1.addAll(queue2);
        queue2.clear();
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
