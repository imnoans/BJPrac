# 문제

---

N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.

N개의 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다.

# 입력

---

첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)

둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.

# 출력

---

한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.


# 풀이

----

우선 Main 함수 내에서 사용할 변수를 정의한다.
arr은 결과문의 출력될 수를 순서대로 저장한다. nums는 사용자로부터 입력받은 수를 저장한다.
n은 입력받는 수의 개수
m은 수열의 길이이다.

    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static int[] nums;
    public static int n, m;

n과 m을 입력받는다.

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

arr, nums, visited를 각각 초기화한다.

    arr = new int[m];
    nums = new int[n];
    visited = new boolean[n];


nums에 값을 입력받는다.
수열은 사전 순으로 출력해야 하므로 nums를 오름차순으로 정렬한다.

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++)
    {
        nums[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(nums);  

dfs() method를 0을 argument로써 호출한다

    dfs(0);

결과문을 출력한다.

    bw.write(sb.toString());
    bw.close();

dfs() method는 다음과 같다. 현재 수열의 길이를 의미하는 count를
 parameter로 가진다.

    public static void dfs(int count)

만약 count가 m이라면 수열이 완성되었으므로 결과문에 추가한다

    if(count == m)
    {
        for(int i = 0; i < m; i++)
        {
            sb.append(arr[i]).append(" ");
        }
        sb.append("\n");
        return;
    }

이 수열이 아직 완성되지 않았다면
중복이 가능하므로 nums에 저장된 index n 까지의 수를
결과문을 출력할 arr에 저장한다. 그 후 수열의 다음 수를 정하기 위해 dfs(count + 1)을 호출한다. 

    for(int i = 0; i < n; i++)
    {
        arr[count] = nums[i];
        dfs(count + 1);
    }

    