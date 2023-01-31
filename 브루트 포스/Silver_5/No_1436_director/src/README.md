# 문제

---

사용자로부터 n이라는 정수를 입력받아 666을 포함하는 n번째로 작은 숫자를
출력하는 문제.

# 풀이

----

사용자로부터 받은 수를 저장하기 위한 n, 몇 번째 666을 포함하는 수인지를 저장하는 
count, 수를 증가시켜 검사하기 위한 num을 정의한다. 이때 num은 666보다 작은 수의
경우 검사할 필요가 없으므로 665 부터 시작한다.

    int n = 0, count = 0, num = 665;

사용자로부터 n을 입력받는다

    n = Integer.parseInt(br.readLine());

count가 n보다 작을 동안 num을 증가시키며 666을 포함하는지 검사한다.
num이 666을 포함할 경우 count를 증가시킨다.

    while(count < n)
    {
        num++;
        if(String.valueOf(num).contains("666"))
        {
            count++;
        }
    }

while문이 끝났을 경우 그 수가 n번째 666을 포함한 수이므로 출력한다.

    bw.write(String.valueOf(num));
    bw.close();