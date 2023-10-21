# https://www.acmicpc.net/problem/2579

stairs = list()
for _ in range(int(input())):
    stairs.append(int(input()))

if len(stairs) == 1 or len(stairs) == 2:
    print(sum(stairs))
    exit()

dp_consecutive = list()
dp_discrete = list()

dp_discrete.append(stairs[0])
dp_consecutive.append(0)
dp_discrete.append(stairs[1])
dp_consecutive.append(dp_discrete[0] + stairs[1])

for i in range(2, len(stairs)):
    dp_discrete.append(max(dp_discrete[i-2], dp_consecutive[i-2]) + stairs[i])
    dp_consecutive.append(dp_discrete[i-1] + stairs[i])

print(max(dp_consecutive[-1], dp_discrete[-1]))