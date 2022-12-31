# 문제

---

사용자로부터 n, q를 입력받는다.
그 후 int 배열 a[n]을 생성하여 입력받는다.
q번 만큼 i, j를 입력받아 a[i] - a[i - 1]의 절대값의 합을 i < j일 동안 구한 뒤 출력한다.

# 풀이

---

사용자로부터 n, q를 입력받는다.

    int n, q;

    StringTokenizer snq = new StringTokenizer(br.readLine());
    n = Integer.parseInt(snq.nextToken());
    q = Integer.parseInt(snq.nextToken());

사용자로부터 n 크기의 int 배열 a의 값을 입력받아 초기화시킨다.

    int[] a = new int[n];
    StringTokenizer sa = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++)
    {
        a[i] = Integer.parseInt(sa.nextToken());
    }

q만큼 테스트 케이스를 반복한다.

    for(int k = 0; k < q; k++)

해당 케이스에서 사용할 i, j를 입력받는다.

    int i, j, sum = 0;
    StringTokenizer sij = new StringTokenizer(br.readLine());
    i = Integer.parseInt(sij.nextToken());
    j = Integer.parseInt(sij.nextToken());

a[i] - a[i - 1]을 i < j일 동안 반복하며 절대값을 sum에 더한다..

    for (int s = i; s < j; s++)
    {
        sum = sum + Math.abs(a[s] - a[s - 1]);
    }

sum을 출력한다.

    bw.write("" + sum + "\n");
    bw.flush();

