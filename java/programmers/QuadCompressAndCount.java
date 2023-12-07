package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/68936

class Solution {
    
    private int zeros;
    private int ones;
    
    public int[] solution(int[][] arr) {
        
        countZerosAndOnes(arr); // 전체 1과 0의 개수 카운트해서 전역변수에 반영
        recursiveCompress(arr, 0, arr.length - 1, 0, arr.length - 1);
        return new int[] {zeros, ones};
    }

    public void recursiveCompress(int[][] arr, int xStart, int xEnd, int yStart, int yEnd) {
        
        // 선택영역 크기가 1x1이 되면 return
        if (xStart == xEnd)
            return;
        
        // 압축 가능 여부 검사, 압축 가능 시 줄어드는 0과 1의 개수 반영
        if (isCompressable(arr, xStart, xEnd, yStart, yEnd))
            return;
        
        // 압축이 불가하면 4등분으로 나누어 재귀 호출
        recursiveCompress(arr, xStart, (xStart + xEnd) / 2, yStart, (yStart + yEnd) / 2);
        recursiveCompress(arr, (xStart + xEnd) / 2 + 1, xEnd, yStart, (yStart + yEnd) / 2);
        recursiveCompress(arr, xStart, (xStart + xEnd) / 2, (yStart + yEnd) / 2 + 1, yEnd);
        recursiveCompress(arr, (xStart + xEnd) / 2 + 1, xEnd, (yStart + yEnd) / 2 + 1, yEnd);
        
    }
    
    public boolean isCompressable(int[][] arr, int xStart, int xEnd, int yStart, int yEnd) {
        
        int cursor = arr[yStart][xStart];
        
        for (int y = yStart; y <= yEnd; y++) {
            for (int x = xStart; x <= xEnd; x++) {
                if (cursor != arr[y][x])
                    return false;
            }
        }
        
        if (cursor == 0) {
            zeros -= Math.pow(xEnd - xStart + 1, 2) - 1;
        }
        else {
            ones -= Math.pow(xEnd - xStart + 1, 2) - 1;
        }
        
        return true;
    }
    
    public void countZerosAndOnes(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 0)
                    zeros++;
                else
                    ones++;
            }
        }
    }
}