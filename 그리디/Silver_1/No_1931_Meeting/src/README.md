# 문제

---

한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.

# 입력

---

첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.

# 출력

---

첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.

# 풀이

---

우선 n을 입력받아 각각의 인덱스에 int[2]로 시작시간과 종료시간을 저장하는 배열
int[][] temp를 생성한다

    n = Integer.parseInt(br.readLine());

    int[][] temp = new int[n][2];

n개의 시작시간과 종료시간을 입력받아 temp[n][0]에는 시작, temp[n][1]에는 종료시간을 저장한다

    for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        temp[i][0] = a;
        temp[i][1] = b;
    }

temp를 우선 종료시간 기준으로 오름차순 정렬하고 종료시간이 같다면 시작시간을 기준으로 오름차순 정렬한다

    Arrays.sort(temp, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
        }
    });

제일 종료시간이 빠른 회의를 선택하고 종료시간 이후 제일 빨리 들어올 수 있는 일찍 끝나는
회의를 선택하도록 이전의 끝나는 시간보다 큰 temp[i][0]을 가진 회의를 선택한다
선택할 때마다 count를 1 증가시킨다.

    preB = temp[0][1];

    for (int i = 1; i < n; i++)
    {
        if (preB <= temp[i][0])
        {
            preB = temp[i][1];
            count++;
        }
    }

count를 출력한다.

    bw.write("" + count);
    bw.close();