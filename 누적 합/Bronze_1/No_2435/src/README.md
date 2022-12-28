# 문제

---

연속된 n개의 숫자를 입력받아 k개씩 묶어서 더했을 때 가장 큰 값을 구하는 문제

# 풀이

-----

우선 몇 개의 숫자를 이용할지를 변수 n에, 몇 개의 숫자를 묶을지를 변수 k에,
n개의 변수를 저장할 ArrayList temper, k개씩 묶은 숫자의 합을 저장할 ArrayList sum을 정의한다.
    
    int n, k, max;
    ArrayList<Integer> temper = new ArrayList<>();
    ArrayList<Integer> sum = new ArrayList<>();

그 후 bufferedReader를 이용하여 한 줄을 입력받은 뒤 StringTokenizer를
이용하여 구분자에 따라 구분하여 temper에 추가한다.

    StringTokenizer st1 = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++)
    {
        temper.add(Integer.parseInt(st1.nextToken()));
    }

n개에 숫자에서 k개의 묶음을 만든다 할 시 총 n - k + 1개의 묶음이 만들어지므로

    for(int j = 0; j <= n - k; j++)
    {
        sum.add(0);

위의 코드를 통해 sum에 하나의 index를 추가한다.

    for(int l = j; l < j + k; l++)
    {
        sum.set(j, sum.get(j) + temper.get(l));
    }
    if(sum.get(j) > max)
    {
        max = sum.get(j);
    }

위의 코드를 통하여 temper의 j번째 인덱스부터 j + k - 1 번째 인덱스까지의 수를
더하여 sum의 j번째 인덱스에 저장한 후 max보다 sum의 j번째 인덱스가 클 시 sum[j]를 max(max는 -10000으로 초기화)에 
대입한다.

반복이 종료된 뒤 max를 출력한다

    bw.write("" + max);

    bw.flush();
    bw.close();

