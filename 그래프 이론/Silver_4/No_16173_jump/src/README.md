# 문제

------

사용자로부터 N * N 크기의 행렬을 입력받은 뒤 1행 1열에서 시작하여 해당 
좌표의 값만큼 행, 열을 각각 이동한 뒤 이동한 행렬에 값만큼 다시 이동하여 3행 3열에
도달할 수 있다면 HaruHaru를 출력하고, 도달할 수 없다면 Hing을 출력한다.

# 풀이

----

우선 사용자로부터 행렬의 크기 N을 입력받은 뒤 점프 거리를 저장하는 colum과
방문 여부를 저장하는 visited를 생성한다.

     int n = Integer.parseInt(br.readLine());

    int colum[][] = new int[n][n];
    boolean visited[][] = new boolean[n][n];    

그 후 dataField로 row, col, power를 가지는 class Location을 정의한다.

    class Location
    {
        public int row;
        public int col;
        public int power;
    
        public Location(int row, int col, int power)
        {
            this.row = row;
            this.col = col;
            this.power = power;
        }
    }     

Location class를 저장하는 Queue canWin을 생성한다.
    
    Queue<Location> canWin = new LinkedList<>();

colum에 값을 입력받는다.

    for(int i = 0; i < n; i++)
    {
        StringTokenizer scol = new StringTokenizer(br.readLine());
        for(int j = 0; j < n; j++)
        {
            colum[i][j] = Integer.parseInt(scol.nextToken());
        }
    }

canWin에 1행 1열에 해당하는 Location을 추가한다

    canWin.add(new Location(0, 0, colum[0][0]));

canWin 행렬이 빌 때까지 행렬의 범위를 벗어나지 않는 다음 위치를 추가한다.
만일 3행 3열(colum값이 -1)에 도착한다면 HaruHaru를 출력하고 while문을 벗어난다.

    while(!canWin.isEmpty())
    {
        Location go = canWin.poll();

        if(visited[go.row][go.col])
        {
            continue;
        }

        visited[go.row][go.col] = true;

        if(go.power == -1)
        {
            bw.write("HaruHaru");
            break;
        }
        if(n > go.row + go.power)
        {
            canWin.add(new Location(go.row + go.power, go.col, colum[go.row + go.power][go.col]));
        }

        if(n > go.col + go.power)
        {
            canWin.add(new Location(go.row, go.col + go.power, colum[go.row][go.col + go.power]));
        }
    }

검사가 끝났는데 3행 3열에 도착한 적이 없다면 Hing을 출력한다.

    if(!visited[n - 1][n - 1])
    {
        bw.write("Hing");
    }

    bw.flush();
    bw.close();