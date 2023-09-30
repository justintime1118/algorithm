'''
링크 : https://leetcode.com/problems/number-of-islands/

문제 해석 : 섬의 배치를 형상화한 2차원 배열이 주어진다 (그래프를 나타내는 인접리스트라고 해석하면 안됨)
이걸 통해 섬의 개수를 return 한다

풀이 방법 : bfs 또는 dfs

노트 
- 어떻게 모든 섬을 다 파악할 수 있게 반복문을 돌릴 것인가 하는 것에서 잠시 고민했음
'''
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

        # 특정 좌표의 방문 여부를 기록하는 그리드
        visited = [[False for i in range(len(grid[0]))] for j in range(len(grid))]
        loop_que = list()
        for row_idx in range(len(grid)):
            for col_idx in range(len(grid[0])):
                if grid[row_idx][col_idx] == "1":
                    loop_que.append((row_idx, col_idx))
        directions = ((0, 1), (0, -1), (1, 0), (-1, 0)) # 사방을 확인하는 로직에 사용할 튜플
        num = 0 # return할 섬의 갯수
        
        bfs_que = list() # bfs 구현을 위한 큐. 그리드 상 특정 좌표를 원소로 갖는다.
        while loop_que:
            # visited에서 False이고 grid에서 값이 1인 좌표를 bfs_que에 넣고 방문한 것으로 표시
            coor = loop_que.pop()
            if (visited[coor[0]][coor[1]] == False) and (grid[coor[0]][coor[1]] == "1"):
                num += 1
                bfs_que.append(coor)
                visited[coor[0]][coor[1]] = True

            # 현재 선택된 섬에 연결된 모든 육지를 visited에 표시
            while bfs_que:
                coor = bfs_que.pop()
                for direction in directions:
                    row_idx = coor[0] + direction[0]
                    col_idx = coor[1] + direction[1]
                    if (0 <= row_idx and row_idx < len(grid))\
                        and (0 <= col_idx and col_idx < len(grid[0]))\
                        and visited[row_idx][col_idx] == False\
                        and grid[row_idx][col_idx] == "1":
                        bfs_que.append((row_idx, col_idx))
                        visited[row_idx][col_idx] = True
        
        return num