# 문제

---

10000까지의 수 중 셀프 넘버를 찾아서 출력하는 문제

# 풀이

---

우선 다른 수를 통해 도달할 수 있는 수를 표시하기 위한 boolean 배열
visited를 만든다.

    public static boolean[] visited;
    visited = new boolean[10001];

find 라는 함수를 통해 해당 숫자의 각 자리수를 구해 다음 수를 구한다. 이 때
find를 통해 다음 수로 갈 경우 그 수는 셀프 넘버가 아니므로 해당 값의 visited 에 true를 대입한다.

만일 10000이 넘거나 이미 visited 표시가 되있는 수라면 다음 수를 검사하는 것은
의미가 없으므로 함수를 종료한다.

    public static void find(int v)
    {
        int value = v;
        int num = v;

        while (num >0) {
            value += num%10;
            num /= 10;
        }

        if(value > 10000 || visited[value])
        {
            return;
        }
        visited[value] = true;
        find(value);
    }

이제 결과문을 생성하기 위한 StringBuilder와 출력하기 위한 BufferedWriter를 생성한다

    StringBuilder sb = new StringBuilder();
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

10000 까지의 수를 모두 find 함수를 통해 검사한다. 이때 visited가 true인 수는
검사할 의미가 없으므로 continue를 통해 넘긴다.

    for(int i = 1; i < 10001; i++)
    {
        if(visited[i])
        {
            continue;
        }
        find(i);
    }

검사가 끝난 후 visited가 false인 수는 셀프 넘버이므로 결과문에 추가한다.

    for(int i = 1; i < 10001; i++)
    {
        if(!visited[i])
        {
            sb.append(i).append("\n");
        }
    }

StringBuilder를 통해 만들어진 결과문을 출력한다.

    bw.write(String.valueOf(sb));
    bw.close();