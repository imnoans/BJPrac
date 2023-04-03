# 문제

---

    그림 1
    0110100
    0110101
    1110101
    0000111
    0100000
    0111110
    0111000

    그림 2
    0110200
    0110202
    1110202
    0000222
    0200000
    0222220
    0222000

<그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.

# 입력

---

첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

# 출력

---

첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

# 풀이

---

상하좌우 이동방향을 정의한다

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

n을 입력받아서 저장한다

    n = int(input())

단지 수를 저장할 number, 단지 수마다 몇개의 집이 있는지 저장하는 counts, 행렬을 저장할 nums를 정의한다

    number = 0
    counts = []
    nums = []

nums를 입력받는다

    for i in range(n) :
        nums.append(list(map(int, input())))

bfs를 정의한다. 좌표 x, y를 parameter로 가지며 해당 좌표를 방문 처리한 후 큐에 추가한다. count또한 1 증가시킨다
def bfs(x, y) :
    queue = deque()
    count = 0
    nums[x][y] = 0
    queue.append((x, y))
    count += 1

queue가 빌 때까지 반복한다. queue에서 가장 먼저 들어온 정점의 좌표를 가져와 dx, dy를 통해 이동시키고 범위를 넘지 않고 방문한 적이 없는 정점이라면 방문 처리 후 count를 1증가시키고 queue에 추가한다.

queue가 비었다면 count를 반환하여 해당 단지 내의 집 수를 저장할 수 있도록 한다

    while queue :
        x, y = queue.popleft()
        for i in range(4) :
            mx = x + dx[i]
            my = y + dy[i]

            if mx < 0 or mx >=n or my < 0 or my >= n :
                continue
            if nums[mx][my] == 1 :
                nums[mx][my] = 0
                count += 1
                queue.append((mx, my))
    return count

전 노드를 돌며 방문하지 않은 노드는 새로운 단지이므로 단지 수를 증가시키고 counts에 bfs에서 반환한 해당 단지 내 집 수를 저장한다

    for i in range(n) :
        for j in range(n) :
            if nums[i][j] == 1 :
                number += 1
                counts.append(bfs(i, j))

단지 수와 단지내 집 수를 오름차순으로 정렬하여 출력한다

    counts.sort()
    print(number)
    for i in counts :
        print(i)