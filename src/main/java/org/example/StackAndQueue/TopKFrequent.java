package org.example.StackAndQueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 提示：
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> myMap = new HashMap<>();
        int[] res = new int[k];
        for (int i : nums) {
            if (!myMap.containsKey(i)) {
                myMap.put(i,1);
            } else {
                myMap.put(i, myMap.get(i) + 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> tempQueue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            //返回值为负数时不需要交换位置，当返回值为正数时交换两个参数得位置，形参得先后代表位置得先后
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() > o2.getValue()){
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        for (Map.Entry i: myMap.entrySet()) {
            tempQueue.offer(i);
        }
        for (int i = 0; i < k; i++) {
            res[i] = tempQueue.poll().getKey();
        }
        return res;
    }
}
