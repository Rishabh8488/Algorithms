package com.learning.scaler.advance.module4.graph1.additional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Problem Description
    You are given N towns (1 to N). All towns are connected via a unique directed path as mentioned in the input.
    Given 2 towns find whether you can reach the first town from the second without repeating any edge.
    B C: query to find whether B is reachable from C.
    Input contains an integer array A of size N and 2 integers B and C (1 <= B, C <= N).
    There exists a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed
    that A[i] <= i for every 1 <= i < N.
    NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.

Problem Constraints
    1 <= N <= 100000

Input Format
    First argument is vector A
    Second argument is integer B
    Third argument is integer C

Output Format
    Return 1 if reachable, 0 otherwise.

Example Input
    Input 1:
     A = [1, 1, 2]
     B = 1
     C = 2
    Input 2:
     A = [1, 1, 2]
     B = 2
     C = 1

Example Output
    Output 1:
     0
    Output 2:
     1

Example Explanation
    Explanation 1:
     Tree is 1--> 2--> 3 and hence 1 is not reachable from 2.
    Explanation 2:
     Tree is 1--> 2--> 3 and hence 2 is reachable from 1.

* */
public class FirstDepthFirstSearch {

    public static void main(String[] args) {
        FirstDepthFirstSearch search = new FirstDepthFirstSearch();

        System.out.println(search.solve(new ArrayList<>(List.of(1, 1, 1, 3, 3, 2, 2, 7, 6)), 9, 1));
    }

    public int solve(ArrayList<Integer> A, final int B, final int C) {
        if (A == null || A.isEmpty()) return 0;
        else if (B == C) return 1;
        List<List<Integer>> adjList = constructAdjList(A);
        if (adjList.size() < C + 1 || adjList.get(C).isEmpty()) return 0;
        boolean[] visited = new boolean[adjList.size() + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(C);
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            if (visited[current]) continue;
            visited[current] = true;
            for (Integer nbr : adjList.get(current)) {
                if (!visited[nbr]) queue.add(nbr);
            }
        }
        return visited[B] ? 1 : 0;
    }

    private List<List<Integer>> constructAdjList(ArrayList<Integer> A) {
        if (A.isEmpty()) return new ArrayList<>();
        int N = A.size();
        List<List<Integer>> result = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++) result.add(new ArrayList<>());
        for (int i = 1; i < N; i++) {
            result.get(A.get(i)).add(i + 1);
        }
        return result;
    }

}
