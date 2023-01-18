# 문제

----

사용자로부터 T를 입력받아 T번의 테스트 케이스에서 첫번째 줄에는 N, M을 입력받는다.
N은 여행하고자 하는 국가의 수, M은 비행기의 종류이다. 이후 M개의 줄을 
입력받아 a, b를 입력받는다. a, b는 a와 b를 왕복하는 비행기가 있다는 의미이다.
최종 목적은 모든 국가를 방문하기 위해 몇 종류의 비행기를 이용해야 하는지 출력하는 것이다.

# 풀이

----

해당 문제는 N개의 정점이 있을 때 모든 정점을 연결하기 위한 최소 간선의 개수를
구하는 문제이다. 여기서 최소 간선의 개수는 N - 1이다.

우선 T를 사용자로부터 입력받은 후 t번만큼 테스트 케이스를 반복한다.

    t = Integer.parseInt(br.readLine());
    for(int i = 0; i < t; i++)

각 테스트 케이스에서 n, m을 입력받은 뒤 해당 그래프의 인접 행렬을 위한 byte 배열
arr을 생성한다.

    StringTokenizer snm = new StringTokenizer(br.readLine());
    n = Integer.parseInt(snm.nextToken());
    m = Integer.parseInt(snm.nextToken());

    byte arr[][] = new byte[n + 1][n + 1];

그 후 a, b를 입력받아서 두 정점이 연결되어 있으면 1로 표시한다.

    int a, b;
    for(int j = 0; j < m; j++)
    {
        StringTokenizer sab = new StringTokenizer(br.readLine());
        a = Integer.parseInt(sab.nextToken());
        b = Integer.parseInt(sab.nextToken());
        arr[a][b] = 1;
        arr[b][a] = 1;
    }

마지막으로 최소 간선의 개수는 N - 1이므로 출력한다.

    bw.write(n - 1 + "\n");

