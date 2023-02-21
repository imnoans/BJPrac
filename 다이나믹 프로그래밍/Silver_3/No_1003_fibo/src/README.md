# 문제

---

    int fibonacci(int n) {
        if (n == 0) {
            System.out.plint("0");
            return 0;
        } else if (n == 1) {
            System.out.plint("1");
            return 1;
        } else {
            return fibonacci(n‐1) + fibonacci(n‐2);
        }
    }

다음과 같은 fibonacci() 가 주어진다. 

테스트 케이스의 개수 t를 입력받는다.

각 테스트 케이스마다 N이 주어지고 fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성한다.

각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.


# 풀이

---

결과문을 생성하기 위한 StringBuilder sb를 정의한다.

        StringBuilder sb = new StringBuilder();

테스트 케이스의 개수 t를 사용자로부터 입력받는다.

        int t = Integer.parseInt(br.readLine());

Main 내에서 사용할 수 있는 참조 변수 memory와 count를 정의한다.

    static Integer[][] memory;

    static int[] count;

테스트 케이스의 개수 t만큼 n을 입력받아 배열에 저장한다.

테스트 케이스의 n 중 가장 큰 값을 max로 정한다.

        int max = 0;
        int[] n = new int[t];
        count = new int[2];

        for(int i = 0; i < t; i++)
        {
            n[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, n[i]);
        }

max + 2 크기를 가진 Integer 배열을 생성하여 memory에 대입한다

        memory = new Integer[max + 2][2];

memory의 0과 1의 값을 초기화시킨다.

        memory[0][0] = 1;
        memory[0][1] = 0;
        memory[1][0] = 0;
        memory[1][1] = 1;

n에 저장된 수를 이용하여 method fibonacci를 호출한다.
그 후 변경된 count[0], count[1]값을 결과문에 추가한다.

        for(int i : n)
        {
            count[0] = 0;
            count[1] = 0;
            fibonacci(i);
            sb.append(count[0]).append(" ").append(count[1]).append("\n");
        }

결과문을 출력한다

        bw.write(sb.toString());
        bw.close();
    }

fibinacci method는 다음과 같다

    static void fibonacci(int n)
    {

만약 n이 이전에 구했던 값이 있다면 그 값만큼 count에 더하고 해당 분기는 종료한다.

        if(memory[n][0] != null || memory[n][1] != null)
        {
            count[0] += memory[n][0];
            count[1] += memory[n][1];
            return;
        }

n == 0이라면 count[0]을, n == 1이라면 count[1]을 증가시킨다

        if (n == 0)
        {
            count[0]++;
        }
        else if (n == 1)
        {
            count[1]++;
        }

0, 1에 해당하지 않으면 다음 fibonacci method를 다시 실행시킨다

        else
        {
            fibonacci(n - 1);
            fibonacci(n - 2);
        }

해당 n의 분기가 모두 끝났으면 저장한다

        memory[n][0] = count[0];
        memory[n][1] = count[1];
    }
