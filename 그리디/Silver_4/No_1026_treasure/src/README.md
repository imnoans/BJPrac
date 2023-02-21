
# 문제

---

옛날 옛적에 수학이 항상 큰 골칫거리였던 나라가 있었다. 이 나라의 국왕 김지민은 다음과 같은 문제를 내고 큰 상금을 걸었다.

길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.

S = A[0] × B[0] + ... + A[N-1] × B[N-1]

S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 단, B에 있는 수는 재배열하면 안 된다.

S의 최솟값을 출력하는 프로그램을 작성하시오.

# 입력

---

첫째 줄에 N이 주어진다. 둘째 줄에는 A에 있는 N개의 수가 순서대로 주어지고, 셋째 줄에는 B에 있는 수가 순서대로 주어진다. N은 50보다 작거나 같은 자연수이고, A와 B의 각 원소는 100보다 작거나 같은 음이 아닌 정수이다.

# 출력

---

첫째 줄에 S의 최솟값을 출력한다.

# 풀이

----

n을 입력받는다, 결과를 저장하기 위한 result를 정의한다.
    
    int n = Integer.parseInt(br.readLine());
    int result = 0;

수열 a와 b를 n크기를 가진 배열로 초기화한다

    int[] a = new int[n];
    Integer[] b = new Integer[n];

사용자로부터 배열 a, b에 값을 입력받는다.

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++)
    {
        a[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++)
    {
        b[i] = Integer.parseInt(st.nextToken());
    }

두 수열의 곱이 최소가 되기 위해서는 a의 가장 작은 수와 b의 가장 큰 수를 곱해야 하므로
a는 오름차순, b는 내림차순으로 정렬한다.

    Arrays.sort(a);
    Arrays.sort(b, Collections.reverseOrder());

a와 b의 곱을 result에 더한다.

    for(int i = 0; i < n; i++)
    {
        result += a[i] * b[i];
    }

result를 출력한다

    bw.write("" + result);
    bw.close();
