package org.example.StringTest;

public class ReplaceNumbers {
        public static String replaceNumber(String s) {
            char[] res = s.toCharArray();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < res.length; i++) {
                int m = res[i] - 'a';
                if (m < 0 || m > 26) {
                    stringBuffer.append("number");
                } else {
                    stringBuffer.append(res[i]);
                }
            }
            return String.valueOf(stringBuffer);
        }

    public static void main(String[] args){
        String s = "a1b2c3";
        String res = replaceNumber(s);
        System.out.println(res);
    }
}
//标答1
//import java.util.Scanner;
//
//class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {//字符串也有length()方法返回长度
//            if (Character.isDigit(s.charAt(i))) {//Character.isDigit 是否是数字
//                sb.append("number");
//            }else sb.append(s.charAt(i));
//        }
//        System.out.println(sb);
//    }
//}

//解法2，数组 为了还原题目本意，先把原数组复制到扩展长度后的新数组，然后不再使用原数组、原地对新数组进行操作。
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
//        int len = s.length();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) >= 0 && s.charAt(i) <= '9') {
//                len += 5;
//            }
//        }
//
//        char[] ret = new char[len];
//        for (int i = 0; i < s.length(); i++) {
//            ret[i] = s.charAt(i);
//        }
//        从后往前遍历，如果从前往后需要对每一个元素进行后移操作，时间复杂度为n^2
//        for (int i = s.length() - 1, j = len - 1; i >= 0; i--) {
//            if ('0' <= ret[i] && ret[i] <= '9') {
//                ret[j--] = 'r';
//                ret[j--] = 'e';
//                ret[j--] = 'b';
//                ret[j--] = 'm';
//                ret[j--] = 'u';
//                ret[j--] = 'n';
//            } else {
//                ret[j--] = ret[i];
//            }
//        }
//        System.out.println(ret);
//    }
//}
