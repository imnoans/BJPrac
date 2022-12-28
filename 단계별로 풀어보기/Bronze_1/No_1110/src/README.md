# 문제

----

주어진 수의 10의 자리 수와 1의 자리 수의 합을 구한 뒤 해당 합의
1의 자리 수를 새로운 수의 일의 자리로 하고 주어진 수의 1의 자리 수를 
새로운 수의 10의 자리 수로 하여 해당 새로운 수가 처음 주어진 수와 같아지기까지
필요한 반복 수를 구하여 출력하는 문제.

# 풀이

---

조건의 맞은 처음 주어진 수 first를 입력받은 후 num에 대입한다.

    do{
        first = sc.nextInt();
    }while(first < 0 || first > 99);
    
    num = first;

새로운 수를 mod라 할 때 first와 mod가 같아지면 while문을 빠져나오도록
설정한다.

    while(first != mod);

만약 주어진 수 num이 10보다 작다면 10의 자리 수 b에 0을 대입한 후
1의 자리 수를 a에 대입한다.

    if(num < 10)
    {
        a = 0;
        b = num;
    }

num이 10보다 크거나 같을 경우 10의 자리 수를 b에 대입하고 1의 자리 수를
a에 대입한다.

    else
    {
        a = num /10;
        b = num % 10;
    }

그 후 a와 b의 합을 구한 뒤 sum에 대입한다

    sum = a + b;

새로운 수의 10의 자리는 b이므로 b에 10을 곱하고 1의 자리는
sum의 1의 자리 수이므로 sum % 10을 한 뒤 둘을 더하여 mod에 대입한다.
과정이 한 번 진행됬으므로 count를 1 증가시킨다.

    mod = (b * 10) + (sum % 10);
    num = mod;
    count++;

while문을 빠져나왔을 때 count의 수를 출력시킨다.

    System.out.println(count);


