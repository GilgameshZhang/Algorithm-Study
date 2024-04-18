package org.example.HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」 定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 */
public class IsHappy {
    public boolean isHappy(int n) {
        Set<Integer> sum = new HashSet<>();
        while (n != 1) {
            int curSum = calUtil(n);
            if (curSum == 1) return true;
            if (!sum.contains(curSum)) {
                sum.add(curSum);
                n = curSum;
            } else {
                return false;
            }
        }
        return true;
    }
    public static int calUtil(int n) {
        int curSum = 0;
        while (n != 0) {
            int t = n % 10;
            curSum += t * t;
            n = (n - t) / 10;
        }
        return curSum;
    }

    public static void main(String[] args) {
        int n = 2;
        IsHappy isHappy = new IsHappy();
        System.out.println(isHappy.isHappy(n));
    }
}
