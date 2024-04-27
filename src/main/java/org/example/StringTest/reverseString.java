package org.example.StringTest;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
public class reverseString {
    //字符串也是种特殊的数组，反转字符串比反转链表简单的多，但二者都是运用了双指针的思想
    public void reverseString1(char[] s) {
        int point1 = 0;
        int point2 = s.length - 1;
        while (point1 < point2) {
            char temp = s[point1];
            s[point1] = s[point2];
            s[point2] = temp;
            point1++;
            point2--;
        }
    }
    //通过位运算异或，不同为1，相同为0
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            s[l] ^= s[r];  //构造 a ^ b 的结果，并放在 a 中
            s[r] ^= s[l];  //将 a ^ b 这一结果再 ^ b ，存入b中，此时 b = a, a = a ^ b
            s[l] ^= s[r];  //a ^ b 的结果再 ^ a ，存入 a 中，此时 b = a, a = b 完成交换
            l++;
            r--;
        }
    }
}
