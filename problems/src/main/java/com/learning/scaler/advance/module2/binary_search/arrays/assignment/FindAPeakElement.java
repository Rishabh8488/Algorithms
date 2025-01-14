package com.learning.scaler.advance.module2.binary_search.arrays.assignment;

import java.util.List;

/*
Problem Description
Given an array of integers A, find and return the peak element in it.
An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor.

NOTE:

It is guaranteed that the array contains only a single peak element.
Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.


Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the peak element.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
Input 2:

A = [5, 17, 100, 11]


Example Output
Output 1:

 5
Output 2:

 100


Example Explanation
Explanation 1:

 5 is the peak.
Explanation 2:

 100 is the peak.
* */
public class FindAPeakElement {

    public static void main(String[] args) {
        System.out.println(solve(List.of(1000000000, 1, 1)));
        System.out.println(solve(List.of(17, 100, 11)));
        //System.out.println(solve(List.of(5, 17, 100, 1100)));
    }

    public static int solve(List<Integer> A) {
        int size = A.size();
        if (size == 1) return A.get(0);
        int start = 0, end = size - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((mid == 0 || A.get(mid) >= A.get(mid - 1)) && (
                    mid == (size - 1) || A.get(mid) > A.get(mid + 1))) return A.get(mid);
            else if (mid == 0 || A.get(mid - 1) < A.get(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }
}
