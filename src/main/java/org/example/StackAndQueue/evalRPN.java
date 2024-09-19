package org.example.StackAndQueue;

import java.util.Stack;

/**
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。
 * 注意：
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * 两个整数之间的除法总是 向零截断 。
 * 表达式中不含除零运算。
 * 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示。
 */
public class evalRPN {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String c : tokens) {
            //判断每个字符串是否是数
            if (c.equals("+")) {
                //如果是则压入栈中
                int i = stack.pop() + stack.pop();
                stack.push(i);
            }else if (c.equals("-")) {
                int i = stack.pop() - stack.pop();
                stack.push(-i);
            }else if (c.equals("*")) {
                int i = stack.pop() * stack.pop();
                stack.push(i);
            }else  if (c.equals("/")) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                int i = temp2 / temp1;
            } else {
                stack.push(Integer.valueOf(c));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] s = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(s));
    }

}
