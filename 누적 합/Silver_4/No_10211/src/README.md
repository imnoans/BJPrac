# 문제

----

n번의 테스트 케이스동안 t크기의 배열에서 가장 큰 합을 가지는 부분의 값을 구하는 문제

# 풀이

---

사용자로부터 테스트 케이스를 수행할 횟수 n을 입력받는다.

    int n;
    n = Integer.parseInt(br.readLine());

테스트 케이스를 위한 for문을 지정한다.

     for(int i =0; i < n; i++)

해당 테스트 케이스에서 사용할 배열의 크기 t를 사용자로부터 입력받는다.

    int t;
    t = Integer.parseInt(br.readLine());
    int[] x = new int[t];

배열의 값을 사용자로부터 입력받는다.

    StringTokenizer sx = new StringTokenizer(br.readLine());
    for(int j = 0; j < t; j++)
    {
        x[j] = Integer.parseInt(sx.nextToken());
    }

최대의 합 max를 x[0]으로 초기화시킨 뒤 0, 01, 012, 0123, 01234,
1, 12와 같이 합하며 max의 값과 비교한 뒤 max보다 크다면 max에 대입한다.

    int max = x[0];
    for(int j = 0; j < t; j++)
    {
        int sum = 0;
        for(int k = j; k < t; k++)
        {
            sum = sum + x[k];
            if(sum > max)
            {
                max = sum;
            }
        }
    }

해당 테스트 케이스의 max를 출력한다.
    
    bw.write("" + max + "\n");

