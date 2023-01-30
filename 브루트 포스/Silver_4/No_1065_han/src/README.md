# 문제

----

각 자리의 수가 등차수열을 이루는 정수를 한수라 할 때 1보다 크고 주어진 수보다
작거나 같은 한수의 개수를 구하는 문제

# 풀이

----

사용자로부터 주어진 수를 입력받는다.

    int size = Integer.parseInt(br.readLine());

주어진 수 만큼 해당 수가 한수인지 아닌지 표시하는 boolean 배열을 만든다.
이 때 수를 그대로 쓰기 위해 index 0을 건너뛰고 사용한다.

    pos = new boolean[size + 1];

한수의 개수를 구하기 위한 count를 생성한다.

    int count = 0;

해당 수가 한수인지 판단하기 위한 method find를 정의한다.
1의 자리 수는 무조건 한수이므로 검사하지 않는다.
해당 수 v의 각 자리의 수를 arr이라는 ArrayList에 저장한다.

    public static void find(int v)
    {
        int num = v;
        ArrayList<Integer> arr = new ArrayList<>();

        if(v < 10)
        {
            return;
        }

        while(num > 0)
        {
            arr.add(num % 10);
            num /= 10;
        }

num 에 10의 자리의 수와 1의 자리의 수의 차를 저장한다.

    num = arr.get(1) - arr.get(0);

index 1부터 ArrayList의 size-1까지 반복하며 해당 인덱스와 다음 인덱스의 차가
num과 같은지 검사한다.

num과 같지 않을 시 한수가 아니므로 pos[v]에 true를 대입한 후 method를 종료한다.

main으로 돌아와 모든 수를 find로 검사한 뒤 pos중 ture가 아닐 경우 한수이므로
count를 증가시킨다.

    for(int i = 1; i <= size; i++)
    {
        find(i);
    }

    for(int i = 1; i <= size; i++)
    {
        if(!pos[i])
        {
            count++;
        }
    }

count를 출력한다.

    bw.write("" + count);
    bw.close();
