package org.example.StringTest;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 * 示例 1：
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 */
public class StrStrTest {
    /**
     * 从左到右遍历haystack，如果其等于needle开头的第一个字母，则从此开始遍历跟needle一样长的路程
     * 如果全一样，则返回该位点，
     * 如果不一样则break；
     * 如果needle比haystack长，则在一开始返回-1
     * 如果第二次遍历到末尾仍没有结束，则break；（数组越界）
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if(haystack.isEmpty()){
            return -1;
        }
        if(haystack.length() < needle.length()) {
            return -1;
        }
        char[] hay = haystack.toCharArray();
        char[] nee = needle.toCharArray();
        for(int i = 0; i < hay.length; i++) {
            if (hay[i] == nee[0]) {
                for (int m = 0; m < nee.length; m++) {
                    if (i + m == hay.length || hay[i+m] != nee[m]) {
                        break;
                    } else if (m == nee.length - 1) {
                        return i;
                    }
                }

            }
        }
        return -1;
    }

    /**
    基于KMP算法实现
     */
    public static int kmpAlgoritm(String haystack, String needle) {
        if (haystack.isEmpty()) {
            return -1;
        }
        int m = 0;
        int[] next = calNext(needle);
        for (int i = 0; i < haystack.length(); i++) {
            char k = haystack.charAt(i);
            char o = needle.charAt(m);
            while (m > 0  && haystack.charAt(i) != needle.charAt(m)) {
                m = next[m - 1];
            }
            if (haystack.charAt(i) == needle.charAt(m)) {
                m++;
            }
            if (m == needle.length()) {
                return i - m + 1;
            }
        }
        return -1;
    }
//计算next数组
    private static int[] calNext(String needle) {
        int j = 0;
        int i = 1;
        int[] next =new int[needle.length()];
        next[0] = j;
        for (; i < needle.length(); i++) {
            if (needle.charAt(j) == needle.charAt(i)) {
                next[i] = next[i - 1] + 1;
                j++;
            } else {
                j = next[i - 1];
                while (needle.charAt(j) != needle.charAt(i) && j > 0) {
                    j = next[j - 1];
                }
                if (j == 0 && needle.charAt(j) == needle.charAt(i)) {
                    next[i] = ++j;
                }else if (j == 0 && needle.charAt(j) != needle.charAt(i)) {
                    next[i] = j;
                }else {
                    next[i] = j + 1;
                    j++;
                }
            }
        }
        return next;
    }

    //标答
    public int strStrTest(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i))
                j = next[j - 1];
            if (needle.charAt(j) == haystack.charAt(i))
                j++;
            if (j == needle.length())
                return i - needle.length() + 1;
        }
        return -1;
    }

    private void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i))
                j = next[j - 1];
            if (s.charAt(j) == s.charAt(i))
                j++;
            next[i] = j;
        }
    }

    public static void main(String[] args) {
        String haystack = "abaababaababab";
        String needle = "abaababab";
        StrStrTest strStrTest = new StrStrTest();
        System.out.println(kmpAlgoritm(haystack, needle));
        System.out.println(strStrTest.strStrTest(haystack, needle));
        System.out.println(calNext(needle));
    }
}
