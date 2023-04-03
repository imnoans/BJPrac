# 문제

---

N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1

미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

# 입력

---

첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

# 출력

---

첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.


# 풀이

---

상하좌우 이동방향을 정의한다

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

결과를 저장하기 위한 result, 행렬의 크기 n, m, 행렬을 저장할 list mat, bfs에 사용할 deque queque를 정의한다

    result = 0
    n, m = map(int, input().split())
    mat = []
    queue = deque()

행렬의 위치와 지나야 하는 칸 수를 저장하는 class loc을 정의한다

    class loc :
        x = 0
        y = 0
        count = 0
        def __init__(self, x, y, count):
            self.x = x
            self.y = y
            self.count = count

mat을 입력받는다

    for i in range(n) :
        mat.append(list(map(int, input())))

mat[0][0]을 방문 처리하고 시작지점을 start로 정의한다

    mat[0][0] = 0

    start = loc(0, 0, 1)

시작지점을 queue에 집어넣는다

    queue.append(start)

무조건 도착할 수 있으므로 실패 조건은 정의하지 않았다.
정의해둔 이동 방향을 따라 이동하여 방문하지 않았다면 queue에 추가하고 방문 처리한다. 이때 v.count를 1증가시켜 지나야 하는 칸 수를 늘린다
방문했던 노드라면 무시한다.
이동한 위치가 범위를 넘는다면 무시한다.
마지막 지점에 도착했다면 result를 v.count로 바꾸고 bfs를 종료한다

    while queue :
        v = queue.popleft()
        if(v.x == n - 1 and v.y == m - 1) :
            result = v.count
            break
        for i in range(4) :
            mx = v.x + dx[i]
            my = v.y + dy[i]
            
            if mx >= n or mx < 0 or my >= m or my < 0 :
                continue
            if mat[mx][my] == 1 :
                #print(mx, my, v.count + 1)
                mat[mx][my] = 0
                queue.append(loc(mx, my, v.count + 1))

result를 출력한다
    print(result)