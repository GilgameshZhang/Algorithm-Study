package org.example.StringTest;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 */
public class ReverseStr {
    public static String reverseStr(String s, int k) {
        char[] res = s.toCharArray();
        for (int t = 0; t < res.length; t = t + 2 * k) {
            if (res.length - t >= k) {
                int p1 = t;
                int p2 = t + k - 1;
                while (p1 < p2) {
                    res[p1] ^= res[p2];
                    res[p2] ^= res[p1];
                    res[p1] ^= res[p2];
                    p1++;
                    p2--;
                }
            } else {
                int p1 = t;
                int p2 = res.length - 1;
                while (p1 < p2) {
                    res[p1] ^= res[p2];
                    res[p2] ^= res[p1];
                    res[p1] ^= res[p2];
                    p1++;
                    p2--;
                }
            }
        }
        String result = new String(res);
        return result;
    }

    //标答
        public String reverseStr1(String s, int k) {
            char[] ch = s.toCharArray();
            for(int i = 0; i < ch.length; i += 2 * k){
                int start = i;
                //这里是判断尾数够不够k个来取决end指针的位置，够不够只影响了end的取值，在此做一个判断即可
                //就不需要繁杂的判断If,提高了代码的可读性
                int end = Math.min(ch.length - 1, start + k - 1);
                //用异或运算反转
                while(start < end){
                    ch[start] ^= ch[end];
                    ch[end] ^= ch[start];
                    ch[start] ^= ch[end];
                    start++;
                    end--;
                }
            }
            return new String(ch);
        }
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String s1 = reverseStr(s, k);
        System.out.println(s1);
    }
}
