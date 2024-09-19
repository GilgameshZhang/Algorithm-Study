package org.example.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class MaxSlidingWindow {
    //大根堆超时
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer> tempQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        int count = 0;
        for (int i : nums) {
            if (tempQueue.size() < k) {
                tempQueue.offer(i);
            }
            if (tempQueue.size() == k){
                res[count] = tempQueue.peek();
                tempQueue.remove(nums[count]);
                count++;
            }
        }
        return res;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        MyQueue myQueue = new MyQueue();
        int count = 1;
        for (int i : nums) {
            if (count < k) {
                myQueue.offer(i);
            } else {
                myQueue.offer(i);
                res[count - k] = myQueue.peek();
                myQueue.pop(nums[count - k]);
            }
            count++;
        }
        return res;
    }

    //单调队列deque标答
    class MyQueue {
        //定义一个双端队列，维护一个递减队列
        Deque<Integer> myQueue = new ArrayDeque<>();

        public MyQueue() {
            this.myQueue = new ArrayDeque<>();
        }

        //offer方法:将数字加进来(如果比当前最后一个数字小，则不进行操作，如果比当前数字大，则最后一个数字出队列，当前数字加进去)
        public void offer(int e) {
            if (myQueue.isEmpty()) {
                myQueue.addLast(e);
            } else {
                while (!myQueue.isEmpty()) {
                    if (e > myQueue.peekLast()) {
                        myQueue.pollLast();
                    } else {
                        break;
                    }
                }
                myQueue.addLast(e);
            }
        }

        //pop方法:将最左端的数字弹出去
        public void pop(int e){
            if (myQueue.peekFirst() == e){
                myQueue.pollFirst();
            }
        }

        //pop方法:返回队列中的最大值
        public int peek(){
            return myQueue.peekFirst();
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        maxSlidingWindow.maxSlidingWindow1(nums, 3);
        //System.out.println(maxSlidingWindow(nums, 3));
    }
}


