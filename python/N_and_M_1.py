# https://www.acmicpc.net/problem/15649
'''
1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열을 출력하라
한줄에 한 수열씩, 각 원소는 공백으로 구분하여 출력한다
'''
n, m = map(int, input().split())

seq = list()

def recur(depth : int):
    # base condition
    if depth == m:
        print(" ".join(seq))
        return
    
    # recursive expression
    for i in range(1, n + 1):
        if str(i) in seq:
            continue
        seq.append(str(i))
        recur(depth + 1)
        seq.pop()

recur(0)

