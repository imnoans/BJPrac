# 문제

---

E, S, M이 있을 때, 이 세 수는 서로 다른 범위를 가진다. (1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)

우리가 알고있는 1년은 1 1 1로 나타낼 수 있다. 1년이 지날 때마다, 세 수는 모두 1씩 증가한다. 만약, 어떤 수가 범위를 넘어가는 경우에는 1이 된다.

이 때 세 수가 주어지고 이것을 우리 세계의 년도로 변환할 시 몇 년인지 출력한다.

# 풀이

----

사용자로부터 입력받는 세 수를 저장하기 위한 e, s, m과 연도를 계산하기 위한
a, b, c, 우리 세계에서의 년도를 표시하기 위한 count를 정의한다. 

    int e, s, m, a = 0, b = 0, c = 0, count = 0;

e, s, m을 입력받는다.

    StringTokenizer sesm = new StringTokenizer(br.readLine());
    e = Integer.parseInt(sesm.nextToken());
    s = Integer.parseInt(sesm.nextToken());
    m = Integer.parseInt(sesm.nextToken());

우리 세계에서 1년이 지날 때마다 문제의 세계의 년도를 계산하여 e, s, m과 같을 시 
while 문을 종료한다. 이 때 e와 s, m은 범위를 벗어날 시 1로 다시 돌아간다.

    while(true)
    {
        a++;
        if(a == 16)
        {
            a = 1;
        }

        b++;
        if(b == 29)
        {
            b = 1;
        }

        c++;
        if(c == 20)
        {
            c = 1;
        }

        count++;

        if(e == a && s == b && m == c)
        {
            break;
        }
    }

count를 출력한다.

    bw.write("" + count);
    bw.close();
