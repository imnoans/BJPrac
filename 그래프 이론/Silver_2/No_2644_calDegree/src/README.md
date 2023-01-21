# 문제

---

사용자로부터 정점의 개수 N을 입력받는다.

탐색을 시작하고자 하는 정점 start와 
찾고자 하는 정점 end를 입력받는다. 

간선의 개수 m을 입력받는다.

m개의 연결된 두개의 정점을 x, y를 입력받는다. x는 부모, y는 자식 관계이다.

이 때 start에서 end 사이에 몇 개의 간선이 있는지 출력한다.

# 풀이

---

우선 class Main 안에서 공통으로 사용할 결과를 저장할 res, 인접 리스트 arr,
방문 여부를 저장할 visited를 정의한다 .

    public static int res = -1;

    public static ArrayList<Integer>[] arr;

    public static boolean[] visited;

main으로 넘어와서 사용자로부터 n을 입력받는다.

    n = Integer.parseInt(br.readLine());

n을 통해 arr과 visited를 생성한다.

     arr = new ArrayList[n + 1];
    visited = new boolean[n + 1];

    for(int i = 1; i < n + 1; i++)
    {
        arr[i] = new ArrayList<>();
    }

사용자로부터 start와 end를 입력받는다.

    StringTokenizer spc = new StringTokenizer(br.readLine());
    start = Integer.parseInt(spc.nextToken());
    end = Integer.parseInt(spc.nextToken());

사용자로부터 m을 입력받는다.

    m = Integer.parseInt(br.readLine());

사용자로부터 연결된 두 개의 정점을 입력받아 arr을 구성한다. 

    for(int i = 0; i < m; i++)
    {
        StringTokenizer sxy = new StringTokenizer(br.readLine());
        x = Integer.parseInt(sxy.nextToken());
        y = Integer.parseInt(sxy.nextToken());

        arr[x].add(y);
        arr[y].add(x);
    }

class Main의 method dfs를 정의한다.

dfs는 parameter로 시작 정점 v, 찾고자 하는 정점 end, 지나간 간선의 수 count를 받는다.

    public static void dfs(int v, int end, int count)

우선 visited[v]를 true로 변경한다.

    visited[v] = true;

정점 v의 인접 리스트 arr[v]의 원소들을 통해 for each 문을 수행하여 방문하지 않은 정점에 대해 다음 dfs를 수행한다.

다음 dfs를 수행할 경우 간선을 하나 지나므로 count를 1 증가시킨다.

    for(int i : arr[v])
    {
        if(!visited[i])
        {
            dfs(i, end, count + 1);
        }
    }

end == v라면 찾고자 하는 정점에 도달했으므로 res 에 count 값을 대입하고 종료한다.

    if(v == end)
    {
        res = count;
        return;
    }

dfs의 처음으로 돌아가 위에서 정의한 res가 -1이 아니라면 정점을 찾은 것이므로 탐색을 수행하지 않고 종료한다.

    if(res != -1)
    {
        return;
    }



