package org.example.StackAndQueue;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 */
public class MyQueue {
    List<Object> myQueue;
    public MyQueue() {
        this.myQueue = new ArrayList<>();
    }
    public void push(int x) {
        myQueue.add(x);
    }

    public int pop() {
        int i = (int)myQueue.get(0);
        myQueue.remove(0);
        return i;
    }

    public int peek() {
            return (int)myQueue.get(0);
    }

    public boolean empty() {
        return myQueue.isEmpty();
    }

    public static void main(String[] s){
         MyQueue obj = new MyQueue();
         obj.push(1);
         obj.push(2);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
    }

    /**
     * 标答
     */
    class MyQueue1 {

        Stack<Integer> stackIn;
        Stack<Integer> stackOut;

        /** Initialize your data structure here. */
        public MyQueue1() {
            stackIn = new Stack<>(); // 负责进栈
            stackOut = new Stack<>(); // 负责出栈
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stackIn.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            dumpstackIn();
            return stackOut.pop();
        }

        /** Get the front element. */
        public int peek() {
            dumpstackIn();
            return stackOut.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stackIn.isEmpty() && stackOut.isEmpty();
        }

        // 如果stackOut为空，那么将stackIn中的元素全部放到stackOut中
        private void dumpstackIn(){
            if (!stackOut.isEmpty()) return;
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
    }

}
