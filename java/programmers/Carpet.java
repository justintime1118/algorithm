package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42842

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] ans = new int[2];
        
        int totalGrid = brown + yellow;
        int outerGrid = 0;
        int width = 0;
        int height = 3;
        
        while (height <= (int)Math.sqrt(totalGrid)) {
            
            width = (totalGrid % height == 0) ? (totalGrid / height) : 0;
            if (width == 0) {
                height++;
                continue;
            }
            
            // 현재 가로 세로 길이로 계산한 바깥쪽 격자 갯수와 brown이 같으면 정답
            outerGrid = width*2 + (height - 2)*2;
            if (outerGrid == brown)
                break;
            
            height++;
        }
        
        ans[0] = width;
        ans[1] = height;
        return ans;
    }
}

/*
<전체 풀이 로직>
반복문으로 height를 3에서부터 1씩 키워가면서
    1) 가로길이 도출. 단, (totalGrid) % height == 0
    2) outerGrid 갯수가 brown과 같아질 때까지 반복

결과적으로 width와 height 도출 가능

<계산 로직>
*totalGrid: brown + yellow
*width: (totalGrid % height == 0) ? (totalGrid / height) : 0
*outerGrid: width*2 + (height-2)*2
*innerGrid: width*height - outerGrid
-> 전체 격자 갯수에 맞춰서 가로 세로 길이를 구했으므로 outerGrid가 맞으면 논리적으로 innerGrid는 당연히 맞으므로 따로 체크를 안해도 됨
*/