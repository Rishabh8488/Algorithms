package com.learning.mock_preparation.day4_searching;


import java.util.Arrays;

/*
Problem Description
    Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of
    the array represents the location of the stall and an integer B which represents the number of cows.
    His cows don't like this barn layout and become aggressive towards each other once put into a stall.
    To prevent the cows from hurting each other, John wants to assign the cows to the stalls,
    such that the minimum distance between any two of them is as large as possible.
    What is the largest minimum distance?


Problem Constraints
    2 <= N <= 100000
    0 <= A[i] <= 10^9
    2 <= B <= N

Input Format
    The first argument given is the integer array A.
    The second argument given is the integer B.

Output Format
    Return the largest minimum distance possible among the cows.

Example Input
    Input 1:
        A = [1, 2, 3, 4, 5]
        B = 3
    Input 2:
        A = [1, 2]
        B = 2

Example Output
    Output 1:
         2
    Output 2:
         1

Example Explanation
    Explanation 1:
         John can assign the stalls at location 1, 3 and 5 to the 3 cows respectively.
         So the minimum distance will be 2.
    Explanation 2:
         The minimum distance will be 1.
* */
public class GFGAggressiveCows {

    public static void main(String[] args) {
        int n = 5, k = 3;
        int[] stalls = new int[]{1, 2, 4, 8, 9};
        System.out.println(solve(n, k, stalls));
    }

    // https://www.geeksforgeeks.org/problems/aggressive-cows/0
    public static int solve(int n, int k, int[] stalls) {
        if (k <= 0 || n <= 0) return 0;
        Arrays.sort(stalls);
        int minDistance = Integer.MAX_VALUE, maxDistance = stalls[n - 1] - stalls[0], result = 0;
        for (int i = 1; i < n; i++) {
            minDistance = Math.min(minDistance, (stalls[i] - stalls[i - 1]));
        }

        while (minDistance <= maxDistance) {
            int checkDistance = minDistance + (maxDistance - minDistance) / 2;
            if (isValidDistance(checkDistance, k, stalls)) {
                minDistance = checkDistance + 1;
                result = checkDistance;
            } else maxDistance = checkDistance - 1;
        }
        return result;
    }

    private static boolean isValidDistance(int givenDistance, int cowCount, int[] stalls) {
        int count = 1, currentPosition = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - currentPosition >= givenDistance) {
                count++;
                currentPosition = stalls[i];
                if (cowCount == count) return true;
            }
        }
        return false;
    }
}