package org.example.HashTable;

import java.util.HashMap;

/**
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * 输出总数n
 * 让nums1和nums2遍历和，nums3,nums4遍历和，形成两个数相加，即重新回到了两数之和的题目
 * 只需要判断nums3，nums4的和的相反数是否出现在nums1与nums2的和中即可
 */
public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();//map<值，出现次数>
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                if (hashMap.containsKey(sum)) {
                    int value = hashMap.get(sum);
                    hashMap.put(sum,value+1);
                } else {
                  hashMap.put(sum,1);
                }
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums3[i] + nums4[j];
                int sub = -sum;
                if (hashMap.containsKey(sub)) {
                    int value = hashMap.get(sub);
                    res += value;
                }
            }
        }
        return res;
    }
}
