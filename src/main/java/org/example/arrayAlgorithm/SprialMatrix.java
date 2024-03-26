package org.example.arrayAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，
 * 请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class SprialMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> nums = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int p = Math.min(m, n);
        int startX = 0;
        int startY = 0;
        int loop = 0;
        int i = 0;
        int j = 0;
        while (loop < p/2) {
            i = startX;
            j = startY;
            for ( ; j < n - loop -1; j++) {
                nums.add(matrix[i][j]);
            }
            for ( ; i < m - loop -1; i++) {
                nums.add(matrix[i][j]);
            }
            for ( ; loop < j; j--) {
                nums.add(matrix[i][j]);
            }
            for ( ; loop < i; i--) {
                nums.add(matrix[i][j]);
            }
            startX++;
            startY++;
            loop++;
        }
        if (p % 2 == 1 && p == m) {
            for (int k = 0; k < n - 2 * loop; k++){
                nums.add(matrix[startX][startY + k]);
            }
        } else if(p % 2 == 1 && p == n) {
            for (int k = 0; k < m - 2 * loop; k++){
                nums.add(matrix[startX + k][startY]);
            }
        }
        return nums;
    }
}
