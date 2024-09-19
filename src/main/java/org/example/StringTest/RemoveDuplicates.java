package org.example.StringTest;

import java.util.Stack;

public class RemoveDuplicates {
    public String removeDuplicates(String s) {
        Stack<Character> temp = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char helper = s.charAt(i);
            if(temp.isEmpty() || temp.peek() != helper) {
                temp.push(helper);
            } else {
                temp.pop();
            }
        }
        if(!temp.isEmpty()) {
            char[] res = new char[temp.size()];
            while (!temp.isEmpty()){
                res[temp.size()- 1] = temp.pop();
            }
            return String.valueOf(res);
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        String s = "azxxzy";
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicates(s));
    }
}
