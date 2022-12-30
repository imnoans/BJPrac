# 문제

---

n개의 숫자 중 연속된 m개의 숫자를 골라 합했을 때 가장 큰 값을 찾는 문제

# 풀이

---

n과 m을 한 줄에 " "을 구분자로 하여 입력받는다.
    
    StringTokenizer snm = new StringTokenizer(br.readLine());
    n = Integer.parseInt(snm.nextToken());
    m = Integer.parseInt(snm.nextToken());

n 크기의 int 배열 x를 생성한다

    int[] x = new int[n];

최대값과 합을 담을 long변수 max, sum을 생성한다.

    long max = 0, sum = 0;

x를 한 줄에 " "를 구분자로 입력받는다.

    StringTokenizer sx = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++)
    {
        x[i] = Integer.parseInt(sx.nextToken());

sum에 x[i]의 값을 더한다.

만약 i가 m보다 클 시 x[i - m]에 있는 값을 sum에서 빼고 x[i]의 값을 추가한다. 

만약 sum이 max보다 크다면 max에 sum의 값을 대입한다.

    if (i >= m) {
        sum -= x[i - m];
    }
    sum += x[i];
    if(sum > max)
    {
        max = sum;
    }

max의 값을 출력한다.

    bw.write("" + max + "\n");