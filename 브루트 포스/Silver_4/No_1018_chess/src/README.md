# 문제

---

사용자로부터 특정한 크기의 보드를 입력받아 그 보드에서 8 X 8 크기의
흰색과 검은색이 번갈아가며 존재하는 체스판을 만들기 위해 다시 칠해야 하는 칸의
최소 개수를 구하는 문제.

# 풀이

---

사용자로부터 보드를 입력받아 저장할 boolean[][] 배열 chessBoard를 준비한다.
이 때 W는 true, B는 false로 입력한다. 또한 최솟값을 저장하기 위한 변수 min 또한 준비한다.
이 두 변수는 First class 내부에서 동일하게 사용하기 위해 static으로 정의한다.

    public static boolean[][] chessBoard;
    public static int min = 64;

사용자로부터 보드의 크기를 입력받아 chessBoard에 boolean[][] 을 생성하여 대입한다.

    StringTokenizer snm = new StringTokenizer(br.readLine());
    n = Integer.parseInt(snm.nextToken());
    m = Integer.parseInt(snm.nextToken());

    chessBoard = new boolean[n][m];

사용자로부터 보드의 무늬를 입력받는다.

    for(int i = 0; i < n; i++)
    {
        String row = br.readLine();
        for(int j = 0; j < m; j++)
        {
            if(row.charAt(j) == 'W')
            {
                chessBoard[i][j] = true;
            }
        }
    }

그 후 칠해야 하는 칸의 최소값을 구하기 위한 함수 find를 정의한다.
find는 parameter로 체스판의 시작 위치(왼쪽 상단의 좌표)를 가진다.

    public static void find(int x, int y)

find 내부에서 칠해야 하는 횟수를 표시하는 count를 정의한다.
    
    int count = 0;

체스판을 검사하기 위해 체스판의 시작 위치의 값을 가져와 first라는 변수에 저장한다.

    boolean first = chessBoard[x][y];

체스판은 우하향 방향으로 검사하는데 오른쪽으로 한 칸 이동할 때마다 전 칸과는
다른 값을 가져야 하므로 first의 값을 not 연산한다. (내부 for 문)

오른쪽 끝까지 이동했다면
다음 행으로 이동해 다시 왼쪽에서 오른쪽부터 검사하는데 이때도 상하로 접한
칸의 값을 달라야 하므로 first의 값을 not 연산한다. (외부 for 문)

    for(int i = 0; i < 8; i++)
        {
            first = !first;
            for(int j = 0; j < 8; j++)
            {
                first = !first;
                if(chessBoard[x + i][y + j] != first)
                {
                    count++;
                }
            }
        }

그 후 첫번째 칸을 다르게 하여 검사하는 경우는 64 - count 이므로 count와
64 - count의 값을 Math.min()을 통해 최소값을 구하고 min과 다시 Math.min()을 통해
최소값을 비교하여 작을 경우 min에 대입한다.

main으로 돌아와 보드가 8 X 8이었을 경우를 대비해 find(0, 0)을 한번 실행한 뒤
8 X 8 보드가 들어갈 수 있는 시작 위치는 n - 7, m - 7 보다 작아야 하므로 이를 이용하여
반복하여 find를 실행한다.

    find(0, 0);
    for(int i = 0; i < n - 7; i++)
    {
        for(int j = 0; j < m - 7; j++)
        {
            find(i, j);
        }
    }

마지막으로 min을 출력한다.

    bw.write("" + min);
    bw.close();
