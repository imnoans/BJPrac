# 문제

-----

입력이 끝날 때까지 두개의 수를 입력받아 합을 출력하는 문제.

# 풀이

-----

bufferedReader의 readLine() method를 이용하여 while 문의 시작 부분에서
한 줄을 입력받아 String 참조변수 line에 저장한 뒤 저장된 line이 
null이거나 길이가 0이라면 반복문을 빠져나간다.

    while((line = br.readLine()) != null && !line.isEmpty())

그 후 StringTokenizer의 nextToken() method를 이용하여 한 줄로 입력받은
line에서 a와 b를 공백을 구분자로 구분하여 각각 입력한다. 만약 a와 b가 주어진
조건을 만족하지 않으면 다시 입력받는다.

    a = Integer.parseInt(st.nextToken());
    if(a <= 0)
    {
        continue;
    }

    b = Integer.parseInt(st.nextToken());
    if(b >= 10)
    {
        continue;
    }

마지막으로 a + b를 출력한 뒤 다시 입력받는다

    System.out.println(a + b);
