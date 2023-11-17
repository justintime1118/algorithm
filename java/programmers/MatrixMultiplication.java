package programmers;

// 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12949

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] ans = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                // arr1의 i행과 arr2의 j열의 곱
                ans[i][j] = calElement(arr1, arr2, i, j);
            }
        }
        return ans;
    }
    
    public int calElement(int[][] arr1, int[][] arr2, int row, int col) {
        int elem = 0;
        for (int i = 0; i < arr1[row].length; i++) {
            elem += arr1[row][i] * arr2[i][col];
        }
        return elem;
    }
}