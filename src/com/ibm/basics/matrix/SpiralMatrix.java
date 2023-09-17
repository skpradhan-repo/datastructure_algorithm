/**
 * 
 */
package com.ibm.basics.matrix;

/**
 * @author 004ISA744
 *
 */
public class SpiralMatrix {
    public static void printSpiralMatrix(int[][] matrix) {
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Print top row
            for (int col = colStart; col <= colEnd; col++) {
                System.out.print(matrix[rowStart][col] + " ");
            }
            rowStart++;

            // Print rightmost column
            for (int row = rowStart; row <= rowEnd; row++) {
                System.out.print(matrix[row][colEnd] + " ");
            }
            colEnd--;

            // Print bottom row
            if (rowStart <= rowEnd) {
                for (int col = colEnd; col >= colStart; col--) {
                    System.out.print(matrix[rowEnd][col] + " ");
                }
                rowEnd--;
            }

            // Print leftmost column
            if (colStart <= colEnd) {
                for (int row = rowEnd; row >= rowStart; row--) {
                    System.out.print(matrix[row][colStart] + " ");
                }
                colStart++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        printSpiralMatrix(matrix);
        // Output: 1 2 3 6 9 8 7 4 5
    }
}
