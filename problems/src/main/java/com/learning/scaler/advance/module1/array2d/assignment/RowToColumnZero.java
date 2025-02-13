package com.learning.scaler.advance.module1.array2d.assignment;


import java.util.Arrays;

/*
Problem Description
    You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0.
    Specifically, make entire ith row and jth column zero.

Problem Constraints
    1 <= A.size() <= 10^3
    1 <= A[i].size() <= 10^3
    0 <= A[i][j] <= 10^3

Input Format
    First argument is a 2D integer matrix A.

Output Format
    Return a 2D matrix after doing required operations.

Example Input
    Input 1:
        [1,2,3,4]
        [5,6,7,0]
        [9,2,0,4]

    Example Output
    Output 1:
        [1,2,0,0]
        [0,0,0,0]
        [0,0,0,0]

Example Explanation
    Explanation 1:
        A[2][4] = A[3][3] = 0, so make 2nd row, 3rd row, 3rd column and 4th column zero.
* */
public class RowToColumnZero {

    public int[][] solve(int[][] matrix) {
        boolean firstRowZero = false, firstColZero = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) firstRowZero = true;
                    if (j == 0) firstColZero = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRowZero) {
            Arrays.fill(matrix[0], 0);
        }
        if (firstColZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        return matrix;
    }
}
