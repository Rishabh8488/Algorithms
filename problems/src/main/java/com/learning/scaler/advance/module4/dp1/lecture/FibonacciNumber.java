package com.learning.scaler.advance.module4.dp1.lecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
Problem Description
    Given a positive integer A, write a program to find the Ath Fibonacci number.
    In a Fibonacci series, each term is the sum of the previous two terms and the first two terms of the series are 0 and 1. i.e. f(0) = 0 and f(1) = 1. Hence, f(2) = 1, f(3) = 2, f(4) = 3 and so on.
    NOTE: 0th term is 0. 1th term is 1 and so on.

Problem Constraints
    0 <= A <= 44

Input Format
    First and only argument is an integer A.

Output Format
    Return an integer denoting the Ath Fibonacci number.

Example Input
    Input 1:
        A = 4
    Input 2:
        A = 6

Example Output
    Output 1:
        3
    Output 2:
        8

Example Explanation
    Explanation 1:
        Terms of Fibonacci series are: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
        0th term is 0 So, 4th term of Fibonacci series is 3.
    Explanation 2:
        6th term of Fibonacci series is 8.
* */
public class FibonacciNumber {
    int[] fibonacciTerms;
    List<Integer> fibonacciSeries;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if (input == 0 || input == 1) System.out.println(input);
        FibonacciNumber number = new FibonacciNumber();
        System.out.println(number.fibonacciIterative(input));
        System.out.println(number.fibonacciRecursive(input));
        System.out.println(number.fibonacciRecursiveNoDp(input));

    }

    private int fibonacciIterative(int input) {
        int term1 = 0, term2 = 1;
        for (int i = 1; i < input; i++) {
            int nextTerm = term1 + term2;
            term1 = term2;
            term2 = nextTerm;
        }
        return term2;
    }

    private int fibonacciRecursive(int input) {
        if (fibonacciTerms == null) {
            fibonacciTerms = new int[input + 1];
            Arrays.fill(fibonacciTerms, 0, input + 1, -1);
        }
        if (input == 0 || input == 1) return input;
        if (fibonacciTerms[input] != -1) return fibonacciTerms[input];
        int currentTerm = fibonacciRecursive(input - 1) + fibonacciRecursive(input - 2);
        fibonacciTerms[input] = currentTerm;
        return fibonacciTerms[input];
    }

    private int fibonacciRecursiveNoDp(int input) {
        if (input == 0 || input == 1) return input;
        return fibonacciRecursiveNoDp(input - 1) + fibonacciRecursiveNoDp(input - 2);
    }

}
