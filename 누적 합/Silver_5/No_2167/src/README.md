# 문제

---

2차원 배열의 크기를 입력받은 뒤 해당 2차원 배열의 값을 입력받는다. 

그 후 k를 입력받고 k 번 만큼 i, j, x, y를 입력받는다.

각 k마다 (i, j)위치부터 (x, y)위치까지의 합을 구하는 문제.

# 풀이

----

변수 n, m에 n, m의 값을 입력받는다.

    StringTokenizer nm = new StringTokenizer(br.readLine());
    n = Integer.parseInt(nm.nextToken());
    m = Integer.parseInt(nm.nextToken());

n 행 m 열을 가지는 2차원 배열을 생성한다

    int[][] arr = new int[n][m];

각 행마다 1줄의 수를 입력받아 각 열에 대입한다.

    for(int q = 0; q < n; q++)
    {
        StringTokenizer inArr = new StringTokenizer(br.readLine());
        for(int w = 0; w < m; w++)
        {
            arr[q][w] = Integer.parseInt(inArr.nextToken());
        }
    }

k를 입력받는다

    k = Integer.parseInt(br.readLine());

k번 만큼 i, j, x, y를 입력받아 합을 계산한 뒤 출력한다.

    for(int e = 0; e < k; e++)
    {
        sum = 0;
        StringTokenizer inIJXY = new StringTokenizer(br.readLine());
        i = Integer.parseInt(inIJXY.nextToken());
        j = Integer.parseInt(inIJXY.nextToken());
        x = Integer.parseInt(inIJXY.nextToken());
        y = Integer.parseInt(inIJXY.nextToken());
        for(int r = i - 1; r <= x - 1; r++)
        {
            for(int t = j - 1; t <= y - 1; t++)
            {
                sum = sum + arr[r][t];
            }
        }
        bw.write("" + sum + "\n");
    }