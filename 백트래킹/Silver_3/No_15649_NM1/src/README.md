# 문제 

---

자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열

# 입력

---

첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

# 출력

---

한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.


# 풀이

----

우선 Main 함수 내에서 사용할 변수를 정의한다.
visited는 해당 정점을 방문했는지의 여부. arr은 결과문의 출력될 수를 순서대로 저장한다. n은 1부터 n까지의 자연수,
m은 수열의 길이이다.

    public static StringBuilder sb = new StringBuilder();
    public static boolean[] visited;
    public static int[] arr;
    public static int n, m;

n과 m을 입력받는다.

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

n 종류의 수를 방문했는지의 여부를 저장하는 visited와 결과문을 저장하기 위한 arr을 초기화한다.

    visited = new boolean[n];
    arr = new int[m];

dfs() method를 0을 argument로써 호출한다

    dfs(0);

결과문을 출력한다.

    bw.write(sb.toString());
    bw.close();

dfs() method는 다음과 같다. 우선 현재 수열의 길이를 의미하는 count를 parameter로서 받아온다.

    public static void dfs(int count)
    
만약 count가 m이라면 수열이 완성되었으므로 결과문에 추가한다

    if(count == m)
    {
        for(int i = 0; i < m; i++)
        {
            sb.append(arr[i]).append(" ");
        }
        sb.append("\n");
        return;
    }

수열이 아직 완성되지 않았다면 n 까지의 수를 방문 처리하고 결과문을 출력할 arr에 저장한다.
그 후 수열의 다음 수를 정하기 위해 dfs(count + 1)을 호출한다.
dfs가 종료되면 그 수는 다시 사용할 수 있는 상태로 돌려놓는다.

    for(int i = 0; i < n; i++)
    {
        if(!visited[i])
        {
            visited[i] = true;
            arr[count] = i + 1;
            dfs(count + 1);
            visited[i] = false;
        }
    }

    