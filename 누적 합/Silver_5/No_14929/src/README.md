# 문제

----

n이 3이라 가정할 때
x[0] * x[1] + x[0] * x[2] + x[1] * x[2] 의 값을 구하는 문제

# 풀이

---

해당 문제를 식으로 변환하면

(x[0]) * x[1] + (x[0] + x[1]) * x[2] + ...... + (x[0] + ... + x[n-1]) * x[n]
이라고 할 수 있다.

우선 n을 입력받는다.

    int n;
    n = Integer.parseInt(br.readLine());

그 후 x[1]과 곱해지는 합을 sum[1]이라 할 때 다음과 같이 입력받는다.

    sum[0] = 0;
    StringTokenizer sx = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
        x[i - 1] = Integer.parseInt(sx.nextToken());
        sum[i] = sum[i - 1] + x[i - 1];
    }

해당 코드를 통해 첫번째 값이 x[0]에 저장되고 x[0]까지의 합은 sum[1],
두번째 값은 x[1]에 저장되고 x[1]까지의 합은 sum[2]에 저장된다.

따라서 sum[1] * x[1] + sum[2] * x[2] + ... 와 같이 진행하면 문제의 조건을 만족할 수 있다.

    for (int i = 1; i < n; i++)
    {
        total = total + x[i] * sum[i];
    }

마지막으로 결과값을 출력한다.

    bw.write("" + total + "\n");
