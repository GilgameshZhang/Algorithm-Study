package org.example.StackAndQueue;

import java.util.*;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        char[] res = s.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        Stack<Character> parentheses = new Stack<>();
        for (char a : res) {
            if (map.containsKey(a)) {
                parentheses.push(map.get(a));
            } else {
                if (parentheses.isEmpty()){
                    return false;
                } else {
                    Character pop = parentheses.pop();
                    if (pop != a) {
                        return false;
                    }
                }
            }
        }
        if (!parentheses.isEmpty()){
            return false;
        }
        return true;
    }

    /**
     * 标答
     * @param s
     * @return
     */
    public boolean isValid1(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            //碰到左括号，就把相应的右括号入栈
            if (ch == '(') {
                deque.push(')');
            }else if (ch == '{') {
                deque.push('}');
            }else if (ch == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || deque.peek() != ch) {
                return false;
            }else {//如果是右括号判断是否和栈顶元素匹配
                deque.pop();
            }
        }
        //最后判断栈中元素是否匹配
        return deque.isEmpty();
    }
}
