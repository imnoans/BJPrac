
# 문제

---

N(1 ≤ N ≤ 100,000)개의 로프가 있다. 이 로프를 이용하여 이런 저런 물체를 들어올릴 수 있다. 각각의 로프는 그 굵기나 길이가 다르기 때문에 들 수 있는 물체의 중량이 서로 다를 수도 있다.

하지만 여러 개의 로프를 병렬로 연결하면 각각의 로프에 걸리는 중량을 나눌 수 있다. k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때, 각각의 로프에는 모두 고르게 w/k 만큼의 중량이 걸리게 된다.

각 로프들에 대한 정보가 주어졌을 때, 이 로프들을 이용하여 들어올릴 수 있는 물체의 최대 중량을 구해내는 프로그램을 작성하시오. 모든 로프를 사용해야 할 필요는 없으며, 임의로 몇 개의 로프를 골라서 사용해도 된다.

# 입력

---

첫째 줄에 정수 N이 주어진다. 다음 N개의 줄에는 각 로프가 버틸 수 있는 최대 중량이 주어진다. 이 값은 10,000을 넘지 않는 자연수이다.

# 출력

---

첫째 줄에 답을 출력한다.

# 풀이

----

사용자로부터 n을 입력받는다

    int n = Integer.parseInt(br.readLine());

n의 크기를 가진 arr에 각 로프가 견딜 수 있는 중량을 저장한다
    
    Integer[] arr = new Integer[n];

arr의 로프의 중량을 입력받는다

    for(int i = 0; i < n; i++)
    {
        arr[i] = Integer.parseInt(br.readLine());
    }

로프의 중량을 내림차순으로 정렬한다

    Arrays.sort(arr, Collections.reverseOrder());

최대 중량을 저장할 max와 가장 적은 중량을 견딜 수 있는 로프의 값을 저장하는
limit를 정의한다.
max는 우선 가장 큰 중량을 견딜 수 있는 로프의 값으로 초기화한다.

    int max = arr[0];
    int limit;

로프를 하나씩 추가하며 견딜 수 있는 중량이 max보다 크다면 max에 대입한다.

    for(int i = 1; i < n; i++)
    {
        limit = arr[i];
        max = Math.max(limit * (i + 1), max);
    }

max를 출력한다

    bw.write("" + max);
    bw.close();
