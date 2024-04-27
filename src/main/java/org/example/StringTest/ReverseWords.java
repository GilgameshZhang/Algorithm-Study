package org.example.StringTest;

/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
 * 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * 示例 1：
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * 示例 3：
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 */
public class ReverseWords {
    public String reverseWords(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] tem = s.toCharArray();
        int quick = tem.length - 1;
        int slow = tem.length - 1;
        //运用双指针的思想，从后面往前面遍历，慢指针指向单词最末尾，快指针指向单词开头
        //每次遍历先慢指针动起来清除空格，快指针等于慢指针，接着往前遍历直到空格即一个单词结束
        //最后再在单词末尾加空格，最后清楚残余的空格
        while (slow >= 0) {
            while (slow >= 0 && tem[slow] == ' ') {
                slow--;
            }
            quick = slow;
            while (quick >= 0 && tem[quick] != ' ') {
                quick--;
            }
            for (int i = quick + 1; i <= slow; i++) {
                stringBuffer.append(tem[i]);
            }
            slow = quick;
            stringBuffer.append(" ");
        }
        int i = stringBuffer.length() - 1;
        while(stringBuffer.charAt(i) == ' ') {//除去后面多余的空格
            stringBuffer.deleteCharAt(i);
            i--;
        }
        return String.valueOf(stringBuffer);
    }
}
