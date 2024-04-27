package org.example.StringTest;

/**
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * 示例 1:
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * 示例 2:
 * 输入: s = "aba"
 * 输出: false
 * 示例 3:
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 */
public class RepeatedSubstringPattern {
    //暴力解法
    public boolean violiteSolution(String s) {
        //获取子串的长度
        for (int i = 1; i < s.length(); i++) {
            String m = s.substring(0, i);
            int k = 0;
            //比较子串和原字符串是否重复构成
            for (; k < s.length(); k++) {
                //吐过循环中不等于，则跳出找下一个新的子串
                if (m.charAt(k % m.length()) != s.charAt(k)) {
                    break;
                }
            }
            //必须字符串要能够整除子串
            if (k == s.length() && k % m.length() == 0) {
                return true;
            }
        }
        return false;
    }
    //KMP算法求解
    public boolean repeatedSubstringPattern(String s) {
        int next[] = calNext(s);
        int res = s.length() - next[s.length() - 1];
        if (res != s.length() && s.length() % res == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int[] calNext(String s) {
        int[] next = new int[s.length()];
        int j = 0;
        next[0] = j;
        for (int i = 1; i < next.length; i++) {
            //当s[i] == s[j]的时候
            if (s.charAt(i) == s.charAt(j)) {
                next[i] = j + 1;
                j++;
            } else {
                j = next[i - 1];
                while (j > 0 && s.charAt(i) != s.charAt(j)) {
                    j = next[j - 1];
                }
                if (s.charAt(i) == s.charAt(j)) {
                    next[i] = j + 1;
                    j++;
                }
                if (j == 0) {
                    next[i] = j;
                }
            }
        }
        return next;
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
        System.out.println(repeatedSubstringPattern.violiteSolution("abaababaab"));
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("abaababaab"));
    }
}
