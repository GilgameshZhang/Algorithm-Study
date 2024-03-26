package org.example.arrayAlgorithm;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 示例:
 * 输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 */
public class SpiralMatrix2 {
    public static int[][] spoiralMatrix2(int n) {
        int[][] nums = new int[n][n];
        int startX = 0;
        int startY = 0;
        int loop = 0;
        int i = 0;
        int j = 0;
        int count = 1;
        int offset = n-1;
        while (loop < n/2) {
            i = startX;
            j = startY;
            for ( ; j < offset; j++) {
                nums[i][j] = count++;
            }
            for ( ; i < offset; i++) {
                nums[i][j] = count++;
            }
            for ( ; n - offset - 1 < j; j--) {
                nums[i][j] = count++;
            }
            for ( ; n - offset - 1 < i; i--) {
                nums[i][j] = count++;
            }
            startX++;
            startY++;
            offset--;
            loop++;
        }
        if (n % 2 == 1) {
            nums[startX][startY] = count;
        }
        return nums;
    }
    public static void main(String[] args) {
        int n = 3;
        int nums[][] = spoiralMatrix2(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(nums[i][j]);
            }
            System.out.println();
        }
    }
}


