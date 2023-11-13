package programmers;

import java.util.*;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/87377

class Solution {

	private static class Point {
        public final long x, y;
        
        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public String[] solution(int[][] line) {
        List<Point> pointList = new ArrayList<>();
        
        // 모든 직선쌍의 조합을 순회하며 존재하는 교점들을 리스트에 추가
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++){
                int a = line[i][0], b = line[i][1], e = line[i][2];
                int c = line[j][0], d = line[j][1], f = line[j][2];
                
                Point intersection = intersection(a, b, e, c, d, f);
				
				if (intersection != null) {
					pointList.add(intersection);
				}
            }
        }
        
		Point minPoint = getMinimumPoint(pointList);
		Point maxPoint = getMaximumPoint(pointList);

		int width = (int) (maxPoint.x - minPoint.x + 1);
		int height = (int) (maxPoint.y - minPoint.y + 1);
		
        // 정답 이차원 배열 선언 및 '.'으로 초기화
        char[][] grid = new char[height][width];
        for (char[] row : grid) {
            Arrays.fill(row, '.');
        }
        
        // 좌표 세트에서 하나씩 꺼내서 *로 표시해준다
        for (Point point : pointList) {
            int x = (int) (point.x - minPoint.x);
			int y = (int) (maxPoint.y - point.y);
			grid[y][x] = '*';
        }
        
        String[] ans = new String[grid.length];
        for (int i = 0; i < ans.length; i++)
            ans[i] = new String(grid[i]);
        return ans;
    }

	/*
	 * 두 직선 사이의 교점을 반환. 교점이 존재하지 않을 경우 null을 반환
	 */
	private Point intersection(long a, long b, long e, long c, long d, long f) {
		double x = (double) (b*f - e*d)/(a*d - b*c);
		double y = (double) (e*c - a*f)/(a*d - b*c);

		if (x % 1 != 0 || y % 1 != 0 || a*d == b*c)
			return null;

		return new Point((long)x, (long)y);
	}

	/*
	 * 가장 작은 x, y 값을 찾아서 Point 형태로 반환
	 */
	private Point getMinimumPoint(List<Point> points) {
		long x = Long.MAX_VALUE;
		long y = Long.MAX_VALUE;

		for (Point p : points) {
			x = p.x < x ? p.x : x;
			y = p.y < y ? p.y : y;
		}

		return new Point(x, y);
	}

	/*
	 * 가장 큰 x, y 값을 찾아서 Point 형태로 반환
	 */
	private Point getMaximumPoint(List<Point> points) {
		long x = Long.MIN_VALUE;
		long y = Long.MIN_VALUE;

		for (Point p : points) {
			x = x < p.x ? p.x : x;
			y = y < p.y ? p.y : y;
		}

		return new Point(x, y);
	}
}