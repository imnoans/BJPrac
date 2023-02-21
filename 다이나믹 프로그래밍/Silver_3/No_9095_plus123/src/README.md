# 문제

---

정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

# 풀이

----

테스트 케이스의 수 t를 입력받는다.

    int t = Integer.parseInt(br.readLine());

해당 경우에서의 값을 저장하기 위한 n, 
자신이 방법의 수를 구하고자 하는 정수 n을 저장하기 위한 start, 
방법의 수를 저장하기 위한 count를 정의한다.

    int n, start, count;

해당 수의 방법의 개수를 저장할 배열 arr을 만든다

    int[] arr = new int[11];

앞에서 계산된 수를 저장하기 위한 ArrayList memory를 만든다.

    ArrayList<Integer> memory = new ArrayList<>();

4를 만드는 방법의 개수는 문제에서 주어졌으므로 저장한다.

    arr[4] = 7;
    memory.add(4);

계산에서 사용할 Queue cal을 생성한다.

    Queue<Integer> cal = new LinkedList<>();

사용자로부터 수를 입력받고 그 수에 대한 계산을 시작하기 위에 cal에 넣는다.

    for (int i = 0; i < t; i++)
    {
        count = 0;
        skip = false;
        start = Integer.parseInt(br.readLine());
        cal.add(start);

cal에 수가 남아있지 않을 때까지 반복하는 while 문을 생성한다

    while(!cal.isEmpty())

cal 에서 수를 꺼내고 0이 되었다면 하나의 방법이 끝난 것이므로 count를 1 증가시킨다.

    n = cal.poll();
    if(n == 0)
    {
        count++;
        continue;
    }

만약 memory에 있는 수와 n이 같다면 방법의 분기는 이미 계산되었으므로 그 수는 cal에 추가하지 않고 count를 증가시킨다.

    for(int j : memory)
    {
        if(n == j)
        {
            count += arr[j];
            skip = true;
            break;
        }
    }

    if(skip)
    {
        skip = false;
        continue;
    }

미리 계산되지 않은 수라면 각각 분기시킨다.

    if(n - 3 >= 0)
    {
        cal.add(n - 3);
    }
    if(n - 2 >= 0)
    {
        cal.add(n - 2);
    }
    if(n - 1 >= 0)
    {
        cal.add(n - 1);
    }

while 문이 끝났다면 지금까지의 count를 arr[start] 에 저장한 후 memory에 해당 수는 계산이 끝났음을 표시한다. 결과문에 count를 추가시킨다.

    arr[start] = count;
    memory.add(start);
    sb.append(count + "\n");

결과문을 출력한다

    bw.write(sb.toString());
    bw.close();