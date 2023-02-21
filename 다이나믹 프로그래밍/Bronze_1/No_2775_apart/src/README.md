
# 문제

---

평소 반상회에 참석하는 것을 좋아하는 주희는 이번 기회에 부녀회장이 되고 싶어 각 층의 사람들을 불러 모아 반상회를 주최하려고 한다.

이 아파트에 거주를 하려면 조건이 있는데, “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다” 는 계약 조항을 꼭 지키고 들어와야 한다.

아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때, 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라. 단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.

# 입력

---

첫 번째 줄에 Test case의 수 T가 주어진다. 그리고 각각의 케이스마다 입력으로 첫 번째 줄에 정수 k, 두 번째 줄에 정수 n이 주어진다

# 출력

---

각각의 Test case에 대해서 해당 집에 거주민 수를 출력하라.

# 풀이

----

결과문을 생성하기 위한 sb를 초기화한다

    StringBuilder sb = new StringBuilder();

테스트 케이스의 수 t를 입력받아 초기화한다

    int t = Integer.parseInt(br.readLine());

각 테스트 케이스의 k, n을 저장할 tcase를 정의한다

    int[][] tcase = new int[t][2];

가장 큰 층수와 호수를 max에 저장한다

    int[] max = new int[2];
    int count;
    for(int i = 0; i < t; i++)
    {
        tcase[i][0] = Integer.parseInt(br.readLine());
        tcase[i][1] = Integer.parseInt(br.readLine());
        max[0] = Math.max(max[0], tcase[i][0]);
        max[1] = Math.max(max[1], tcase[i][1]);
    }

가장 큰 층수와 호수만큼 apart를 생성한다

    int[][] apart = new int[max[0] + 1][max[1] + 1]; // 층 / 호

아파트의 0층의 값은 위에서 주어졌으므로 초기화한다

    for(int i = 1; i < max[1] + 1; i++)
    {
        apart[0][i] = i;
    }

1층 부터는 아래층의 값에 의해 정해진다
count에 아래 층에 해당 호수까지의 값을 더하여 저장한 뒤 대입한다.
마지막 호까지 더했다면 count를 0으로 다시 초기화한다

    for(int i = 1; i < max[0] + 1; i++)
    {
        count = 0;
        for(int j = 1; j < max[1] + 1; j++)
        {
            count += apart[i - 1][j];
            apart[i][j] = count;
        }
    }

apart에 저장된 각 테스트 케이스의 k, n에 해당하는 값을 결과문에 추가한다

    for(int i = 0; i < t; i++)
    {
        sb.append(apart[tcase[i][0]][tcase[i][1]]).append("\n");
    }

결과문을 출력한다

    bw.write(sb.toString());
    bw.close();