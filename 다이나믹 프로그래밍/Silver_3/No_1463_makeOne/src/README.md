# 문제

---

정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다. 

X가 2로 나누어 떨어지면, 2로 나눈다.

1을 뺀다.

정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

# 풀이

---

정수 x를 입력받는다

    int x = Integer.parseInt(br.readLine());

계산 횟수를 보여주기 위한 count를 생성한다

    int count = 0;
    
계산한 수를 저장하기 위한 Queue cal과 해당 수에 접근하기까지 필요한 count를 저장하기 위한 int 배열 arr을 생성한다.

    Queue<Integer> cal = new LinkedList<>();
    int[] arr = new int[x + 1];

입력받은 x를 cal에 저장한다.

    cal.add(x);

cal에서 수를 하나씩 가져와 count는 해당 수까지 걸린 횟수에 1을 더한 값이다.

3, 2의 배수인지 확인하고 해당 수를 계산한 결과가 앞에서 이미 계산했던 결과라면 추가하지 않는다.

해당 수가 1보다 작은 경우에는 도달할 수 없으므로 더이상 계산하지 않는다.

계산 결과를 cal에 추가하고 해당 결과를 인덱스로 arr에 count를 저장한다.

    while(true)
    {
        x = cal.poll();
        if(x == 1)
        {
            break;
        }
        count = arr[x] + 1;

        if(x < 1)
        {
            continue;
        }
        if(x % 3 == 0 && arr[x / 3] == 0)
        {
            cal.add(x / 3);
            arr[x / 3] = count;
        }
        if(x % 2 == 0 && arr[x / 2] == 0)
        {
            cal.add(x / 2);
            arr[x / 2] = count;
        }
        if(arr[x - 1] == 0)
        {
            cal.add(x - 1);
            arr[x - 1] = count;
        }
    }

1의 count를 출력한다.

    bw.write("" + arr[1]);
    bw.close();



