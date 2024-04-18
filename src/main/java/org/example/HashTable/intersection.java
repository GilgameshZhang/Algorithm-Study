package org.example.HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集
 *  输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 */
public class intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> hashSet1 = new HashSet();
        Set<Integer> result = new HashSet();
        for (int i : nums1) {
            hashSet1.add(i);
        }
        for (int i : nums2) {
            if (hashSet1.contains(i)) {
                result.add(i);
            }
        }
        int[] arr = new int[result.size()];
        int j = 0;
        for (int i : result) {
            arr[j] = i;
            j++;
        }
        return arr;
    }
}
