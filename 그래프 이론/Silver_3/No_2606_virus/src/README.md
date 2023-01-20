# 문제

---

사용자로부터 컴퓨터(정점)의 개수 num과 연결된 컴퓨터 쌍(간선)의 개수 edge를
받아 edge 개수만큼 연결된 두 정점을 입력받은 후 1 정점과 연결된 정점의 개수를
구하는 문제.

# 풀이

----

사용자로부터 정점의 개수 num을 입력받은 뒤 연결 정보를 저장하는 arr과 방문 정보를
입력하는 visited를 생성한다. 이 때 정점 번호를 index와 같게 하기 위해 num + 1개만큼 생성한다.

    boolean[][] arr = new boolean[num + 1][num + 1];
    boolean[] visited = new boolean[num + 1];

사용자로부터 간선의 개수 edge를 입력받은 뒤 edge 개수만큼 연결된 두 정점 a, b를
입력받아 연결 정보를 arr에 저장한다.

    edge = Integer.parseInt(br.readLine());

    for(int i = 0; i < edge; i++)
    {
        StringTokenizer sab = new StringTokenizer(br.readLine());
        a = Integer.parseInt(sab.nextToken());
        b = Integer.parseInt(sab.nextToken());

        arr[a][b] = true;
        arr[b][a] = true;
    }

BFS를 Queue를 통해 구현한다. Queue에 1을 추가한 뒤 1을 방문 처리한다.
Queue에서 가장 먼저 입력된 값을 꺼낸 뒤 해당 정점과 연결되어 있고 방문하지 않은
정점을 Queue에 추가하는 것을 Queue가 빌 때까지 반복한다. 
Queue에 정점을 추가할 때마다 count를 1씩 증가시킨다.

    while (!bfs.isEmpty())
    {
        a = bfs.poll();
        for(int i = 1; i < num + 1; i++)
        {
            if(arr[a][i] && !visited[i])
            {
                count++;
                visited[i] = true;
                bfs.add(i);
            }
        }
    }

count를 출력한다.

    bw.write("" + count);


