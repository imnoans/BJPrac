# 문제

---

트리의 최상위 정점을 1로 설정한 트리에서 노드의 개수 N을 받아온다. 
이후 N-1개의 연결된 두 정점의 집합을 받아온다.
그 이후 정점 2부터 N까지 자신의 부모 정점이 무엇인지 한 줄씩 출력한다.

# 풀이

---

사용자로부터 정점의 개수 n을 받아온다.

    n = Integer.parseInt(br.readLine());

n을 통하여 각 정점의 인접 리스트인 arr과 방문 여부를 나타내는 visited,
해당 정점의 부모 정점을 나타내는 parent를 생성한다.

    ArrayList<Integer>[] arr = new ArrayList[n + 1];
    boolean[] visited = new boolean[n + 1];
    int[] parent = new int[n + 1];
    
    for(int i = 1; i < n + 1; i++)
    {
        arr[i] = new ArrayList<>();
    }

n - 1 개의 연결된 정점의 집합을 받아서 각 정점의 인접 리스트에 저장한다.

    for(int i = 0; i < n - 1; i++)
    {
        StringTokenizer sab = new StringTokenizer(br.readLine());
        a = Integer.parseInt(sab.nextToken());
        b = Integer.parseInt(sab.nextToken());
        arr[a].add(b);
        arr[b].add(a);
    }

dfs를 구현한다. parameter로 정점 v, 인접 리스트 arr, 방문 정보 visited,
부모 정점 parent를 받아온다.

    public static void dfs(int v, ArrayList<Integer>[] arr, boolean[] visited, int[] parent)

v정점을 방문 처리한 뒤 arr[v]에 저장된 v와 연결된 정점을 가져와 for each를 이용하여
해당 정점과 연결된 정점들을 i에 대입한 뒤 i를 방문하지 않았다면 i정점의 부모를 v로 지정하고
i로 다시 dfs를 호출한다.

    for(int i : arr[v])
    {
        if(!visited[i])
        {
            parent[i] = v;
            dfs(i, arr, visited, parent);
        }
    }

dfs를 1부터 시작한다(1이 최상위 정점)

    dfs(1, arr, visited, parent);

정점 2부터 마지막 정점까지 부모 정점을 출력한다.

    for(int i = 2; i < n + 1; i++)
    {
        bw.write("" + parent[i] + "\n");
    }