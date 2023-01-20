# 문제

---

사용자로부터 정점의 개수 N, 간선의 개수 M, 탐색을 시작할 번호 V를 입력받는다.
그 후 간선의 개수만큼 연결된 정점을 a, b로 입력받는다. 해당 그래프에서 DFS와 BFS를
각각 사용하여 방문하게 되는 정점들을 순서대로 출력한다.

# 풀이

---

사용자로부터 N, M, V를 입력받는다. 이 때 N, M, V는 First class 내부에서 공유하여
사용할 수 있도록 static dataField로 정의한다.

    public static int n, m, v;

    StringTokenizer snmv = new StringTokenizer(br.readLine());

    n = Integer.parseInt(snmv.nextToken());
    m = Integer.parseInt(snmv.nextToken());
    v = Integer.parseInt(snmv.nextToken());

두 정점의 연결 정보를 저장하는 인접 행렬 arr을 생성한다. arr또한 static으로 정의한다. 이때 정점에 해당하는 
수와 index를 맞추기 위해 arr은 정점의 개수보다 1많게 생성한다.

    public static byte[][] arr;
    arr = new byte[n + 1][n + 1];

간선의 개수만큼 연결된 두 정점을 입력받은 뒤 연결 정보를 arr에 저장한다.

    for(int i = 0; i < m; i ++)
    {
        int a, b;
        StringTokenizer sab = new StringTokenizer(br.readLine());
        a = Integer.parseInt(sab.nextToken());
        b = Integer.parseInt(sab.nextToken());

        arr[a][b] = 1;
        arr[b][a] = 1;
    }

정점의 방문 여부를 저장하는 visited를 생성한다.

    boolean[] visited = new boolean[n + 1];

결과문을 생성하기 위한 StringBuilder sb를 static으로 생성한다.

    public static StringBuilder sb = new StringBuilder();

DFS는 재귀함수를 통하여 구현한다. parameter는 시작 정점 v와 visited를 받아온다.
sb에 v를 더한 뒤 visited[v]를 true로 변경한다(방문 처리). 그 후 v와 연결된
정점을 찾기 위해 N만큼 for문을 수행한다.

    public static void DFS(int v, boolean visited[])
    {
        sb.append(v + " ");
        visited[v] = true;
        for(int i = 1; i < n + 1; i ++)

for문은 방문했던 정점과 연결되어 있고 방문하지 않았던 정점이 있다면 해당 정점을
시작 정점으로 하는 DFS를 다시 호출한다.

    if(arr[v][i] == 1 && !visited[i])
    {
        DFS(i, visited);
    }

BFS는 parameter로 visited를 이용한다.

    public static void BFS(boolean[] visited)

BFS는 Queue를 이용하여 구현한다. 우선 시작 정점 v를 Queue에 추가한다.
visited[v]를 방문 처리한다. 정점의 값을 저장할 num을 정의한다.

    Queue<Integer> bfs = new LinkedList<>();
    visited[v] = true;
    bfs.add(v);
    int num;

그 후 Queue가 빌 때까지 while문을 반복한다.

    while(!bfs.isEmpty())

Queue에 남아있는 제일 먼저 입력된 정점의 값을 num에 저장한 뒤 sb를 통해 결과문을 생성한다.

    num = bfs.poll();
    sb.append(num + " ");

num의 값에 해당하는 정점과 연결되어 있고 방문한 적이 없는 정점을 찾은 뒤 방문 처리하고
Queue에 추가한다.
    
    for(int i = 1; i < n + 1; i ++)
    {
        if(arr[num][i] == 1 && !visited[i])
        {
            bfs.add(i);
            visited[i] = true;
        }
    }

DFS를 실행한 뒤 sb를 통해 줄바꿈한 뒤 visited를 초기화하여 BFS를 실행한다.
마지막으로 sb에 저장된 값을 출력한다.

    boolean[] visited = new boolean[n + 1];
    DFS(v, visited);
    sb.append("\n");

    visited = new boolean[n + 1];
    BFS(visited);

    bw.write(sb.toString());
    

    