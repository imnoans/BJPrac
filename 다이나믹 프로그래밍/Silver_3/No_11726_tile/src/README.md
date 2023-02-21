# 문제

---

2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
이 때 경우의 수는 10007로 나눈 나머지 값을 출력한다.

# 풀이

---

2 * n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수는 n을 1혹은 2의 합으로
표현하는 것과 같다.

Main 함수 전체에서 사용할 변수들을 정의한다.

    static Integer[] done;

    static int count = 0;

우선 사용자로부터 n을 입력받는다

    int n = Integer.parseInt(br.readLine());

계산이 끝난 수를 저장할 done을 초기화한다.

    done = new Integer[n + 1];

tiling() method에 n을 대입하여 호출한다.

    tiling(n);

done[n]에 저장된 값은 n의 경우의 수이므로 출력한다

    bw.write("" + done[n]);
    bw.close();

tiling method는 다음과 같다

우선 시작 정점 v를 입력받는다.

    public static void tiling(int v)
    {

만약 v가 0보다 작으면 범위를 벗어난 것이므로 추가하지 않는다.

        if(v < 0)
        {
            return;
        }

v가 0이라면 한 경우가 끝난 것이므로 count를 증가시킨다.

        if(v == 0)
        {
            count++;
            return;
        }

만약 done[v]가 null이 아니라면 이미 계산한 적이 있는 경우이므로 저장된 값을
count에 더하고 해당 분기를 종료한다.

        if(done[v] != null)
        {
            count += done[v];
            return;
        }

다음 분기로 갈라진다. 1과 2로 구성하므로 v - 1, v - 2로 호출한다

        tiling(v - 1);
        tiling(v - 2);

method의 끝에 도달했다는 것은 처음으로 v에 대한 경우의 수 연산이 끝난 것이므로
done에 count를 저장한다. 이 때 문제에서 10007로 나눈 나머지를 출력한다 했으므로 % 10007을 한 값을 저장한다

        done[v] = count %= 10007;
    }