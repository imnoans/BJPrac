# 문제

----
사용자로부터 바닥의 크기 n, m을 입력받는다(n은 행, m은 열)
‘-’와 ‘|’로 이루어진 바닥 장식 모양이 주어진다. 만약 두 개의 ‘-’가 
인접해 있고, 같은 행에 있다면, 두 개는 같은 나무 판자이고, 두 개의 ‘|’가
인접해 있고, 같은 열에 있다면, 두 개는 같은 나무 판자이다.
입력받은 모양을 만드는 데 필요한 나무 판자의 개수를 출력한다.

# 풀이

---

바닥의 크기 n, m을 입력받는다.

    StringTokenizer snm = new StringTokenizer(br.readLine());
        n = Integer.parseInt(snm.nextToken());
        m = Integer.parseInt(snm.nextToken());

해당 바닥을 저장하는 char[][] floor를 만든다. 이때 0번째 열은 '|'로
0번째 행은 '-'로 채워야 하므로 char[n+1][m+1] 로 구성한다.

    char[][] floor = new char[n + 1][m + 1];

사용자로부터 바닥 모양을 입력받는다.

    for (int i = 0; i < n; i++) {
        floor[i + 1][0] = '|';
        String st = br.readLine();
        for (int j = 0; j < m; j++) {
            floor[0][j + 1] = '-';
            floor[i + 1][j + 1] = st.charAt(j);
        }
    }

같은 행에 - 그룹이 몇 개 있는지 검사한다. (전 인덱스에 |가 있고 현 인덱스에 -가 있으면 새로운 그룹)

    for(int i = 1; i < n + 1; i++)
    {
        for(int j = 0; j < m; j++)
        {
            if(floor[i][j] == '|' && floor[i][j + 1] == '-')
            {
                count++;
            }
        }
    }

같은 열에 | 그룹이 몇 개 있는지 검사한다. (전 인덱스에 -가 있고 현 인덱스에 |가 있으면 새로운 그룹)

    for(int i = 1; i < m + 1; i++)
    {
        for(int j = 0; j < n; j++)
        {
            if(floor[j][i] == '-' && floor[j + 1][i] == '|')
            {
                count++;
            }
        }
    }

count를 출력한다
    
    bw.write("" + count);