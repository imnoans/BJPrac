# 문제

---

사용자로부터 배열의 크기 n, 연속된 숫자의 수 k를 입력받아 연속된 k의 숫자의
총합 중 가장 큰 값을 출력하는 문제.

단 배열에 끝과 시작은 이어져 있다.

# 풀이

---

사용자로부터 n, k를 입력받는다. n 크기의 int 배열 a를 생성한다.
    
    StringTokenizer snk = new StringTokenizer(br.readLine());
    n = Integer.parseInt(snk.nextToken());
    k = Integer.parseInt(snk.nextToken());
    int[] a = new int[n];

a에 값을 입력받는다.

    StringTokenizer sa = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++)
    {
        a[i] = Integer.parseInt(sa.nextToken());
    }

우선 맨 끝과 처음이 연결되 있으므로 총 n + k - 1개의 부분 배열이 생긴다.

    for(int i = 0; i < n + k - 1; i++)

i가 k보다 작을 경우 총합에 a[i]를 더한다.

    if(i < k)
    {
        sum += a[i];
    }

i가 k보다 크거나 같고 n보다 작을 경우 총합에 a[i]를 더하며 a[i - k]를 뺀다.

    else if(i < n)
    {
        sum += a[i];
        sum -= a[i - k];
    }

i가 n보다 크거나 같을 시 총합에서 a[i - k]를 빼고 a[i - n]을 더한다.
(배열의 끝에 도달할 시 다시 처음으로 돌아감.)
    
    else {
        sum -= a[i - k];
        sum += a[i - n];
    }

각 단계에서 sum이 max보다 클 경우 max에 sum을 대입한다.

    if(sum > max)
    {
        max = sum;
    }

마지막으로 max를 출력한다

    bw.write("" + max + "\n");


