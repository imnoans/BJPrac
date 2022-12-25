# 문제

------
for문의 반복횟수를 사용자로부터 bufferedReader를 통하여 입력받은 후
해당 for문 안에서 사용자로부터 두 숫자 a b를 입력받아 두 수의 합을 
bufferedWriter를 통하여 출력하는 문제.

# 풀이

------
bufferedReader의 참조변수 선언 형식은 다음과 같다.

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

bufferedReader의 한 줄을 읽기 위해 필요한 method는

    String readLine()
    한 줄을 읽는다

반복 횟수를 정하기 위한 T는 한 줄에 하나만 입력받으므로 

    t = Integer.parseInt(bf.readLine());

를 이용하여 한 줄을 읽고  입력된 숫자를
문자열로 받아들이므로 Integer.parseInt를 이용하여 int형으로 변환한다.
t를 이용하여 입력 반복 횟수를 정한다.

    for(int i = 0; i < t; i++)


그 후 readline method는 한 줄을 읽어 String으로 반환하므로 주어진 입력에서
공백을 구분자로 구분하기 위해서는 StringTokenizer의 nextToken() method를 사용할 수 있다.

StringTokenizer를 생성할 때 argument로 br.readline을 전달한다. 

    StringTokenizer st = new StringTokenizer(br.readLine());

그 후 StringTokenizer의 method인 String nextToken()을 이용하여 기본 구분자인
공백(\t, \n, \r, \t)이 있을 때마다 문자열을 분리한다. 입력된 숫자를 
문자열로 받아들이므로 Integer.parseInt를 이용하여 int형으로 변환한다.

    a = Integer.parseInt(st.nextToken());

만약 a가 제시한 조건에 맞지 않는다면 반복문을 다시 진행한다.

    if(a > 1000 || a < 1)
    {
        i--;
        continue;
    }

b 또한 같은 방식으로 진행한다.

    b = Integer.parseInt(st.nextToken());
    if(b > 1000 || b < 1)
    {
        i--;
        continue;
    }

그 후 출력을 위해 bufferedWriter를 사용한다.

bufferedWriter의 참조변수 선언 방식은 다음과 같다.
    
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

bufferedWiter의 method는 다음과 같다

    void	close()
    스트림을 닫음. 닫기 전 flush().
    void	flush()
    스트림을 비움
    void	write(String s, int offset, int length)
    문자열에서 offset에서부터 일정 길이만큼 write

a와 b를 더한 값과 개행 문자를 출력한다

    bw.write((a + b) + "\n");
    
반복문이 끝나면 bufferdWriter가 버퍼를 사용하기 때문에 버퍼를 비우고 닫아야 한다.

    bw.flush();
    bw.close();