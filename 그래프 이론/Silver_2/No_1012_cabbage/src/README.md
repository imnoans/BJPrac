# 문제

---

사용자로부터 테스트 케이스의 개수 T를 입력받아 T번의 테스트 케이스에서 각각
열의 개수 M과 행의 개수 N, 1의 개수 K를 입력받는다.
그 후 K개 만큼의 좌표를 입력받는다. 한 좌표에서 상하좌우에 1이 있다면 그 좌표와는 연결된 것으로 한다.
이 때 서로 다른 연결된 좌표의 집합의 개수를 구한다.

# 풀이

---

사용자로부터 T를 입력받아 테스트 케이스를 위한 for문을 생성한다.

    t = Integer.parseInt(br.readLine());

    for(int q = 0; q < t; q++), M, N, K

테스트 케이스 for문 안에서 M, N, K를 입력받는다.

    StringTokenizer snmk = new StringTokenizer(br.readLine());

    m = Integer.parseInt(snmk.nextToken());
    n = Integer.parseInt(snmk.nextToken());
    k = Integer.parseInt(snmk.nextToken());

N과 M에 해당하는 좌표계 arr과 해당 좌표의 방문 여부를 저장하는 visited를 생성한다.

    byte[][] arr = new byte[m][n];

    boolean[][] visited = new boolean[m][n];

K만큼 1이 입력되는 좌표를 입력받는다.

    for(int i = 0; i < k; i++)
    {
        StringTokenizer sab = new StringTokenizer(br.readLine());
        a = Integer.parseInt(sab.nextToken());
        b = Integer.parseInt(sab.nextToken());

        arr[a][b] = 1;
    }

연속된 집합을 찾기 위한 함수 find를 정의한다.
find는 parameter로 i, j, arr, visited를 받아온다.

    static public void find(int i, int j, byte[][] arr, boolean[][] visited)

find에서는 i, j에 해당하는 좌표를 방문 처리하고 범위 안에 있는 상하좌우를 검사해
방문하지 않았다면 해당 좌표에 대하여 다시 find를 호출한다.

    visited[i][j] = true;
    if(i + 1 < arr.length && arr[i + 1][j] == 1 && !visited[i + 1][j])
    {
        find(i + 1, j, arr, visited);
    }
    if(j + 1 < arr[i].length && arr[i][j + 1] == 1 && !visited[i][j + 1])
    {
        find(i, j + 1, arr, visited);
    }
    if(i - 1 >= 0 && arr[i - 1][j] == 1 && !visited[i - 1][j])
    {
        find(i - 1, j, arr, visited);
    }
    if(j - 1 >= 0 && arr[i][j - 1] == 1 && !visited[i][j - 1])
    {
        find(i, j - 1, arr, visited);
    }

main으로 돌아와서 각 좌표마다 방문 여부와 1 값을 가지는지를 검사하여 
count를 증가시키고 해당 집합에 대한 find를 수행한다.
이 때 find가 연속된 집합에 한 번 수행되면 연속된 집합들의 visited값은 항상
true이므로 false이면서 1 값을 가지는 좌표는 새로운 집합이다. 
따라서 count를 1 증가시킨다.

    for(int i = 0; i < m; i++)
    {
        for(int j = 0; j < n; j++)
        {
            if(!visited[i][j] && arr[i][j] == 1)
            {
                count++;
                find(i, j, arr, visited);
            }
        }
    }