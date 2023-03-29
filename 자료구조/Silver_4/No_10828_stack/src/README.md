# 문제

---

정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 다섯 가지이다.

push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.

# 입력

---

첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

# 출력

---

출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.

# 풀이

---

    int n, a;

명령의 수 n과 stack에 넣기 위한 수를 저장하는 a를 정의한다

    String str;

명령을 저장하기 위한 문자열 str을 정의한다

    Stack<Integer> stack = new Stack<>();

스택을 생성한다

    n = Integer.parseInt(br.readLine());

n을 입력받는다

    for(int i = 0; i < n; i++)
    {
        st = new StringTokenizer(br.readLine());
        str = st.nextToken();

n번 반복하며 명령을 입력받는다

        if(str.equals("push"))
        {
            a = Integer.parseInt(st.nextToken());
            stack.push(a);
        }

입력받은 문자열이 push일 경우 st에 저장된 다음 문자열을 받아 정수로 변환하여 a에 저장한다.
a를 stack에 push 한다

        else if(str.equals("pop"))
        {
            if(stack.isEmpty())
            {
                sb.append("-1\n");
            }
            else
            {
                sb.append(stack.pop()).append("\n");
            }
        }

입력받은 문자열이 pop일 경우 우선 stack이 비었는지 검사하고 비었다면 -1을, 비어있지 않다면
pop() 메소드를 통해 요소를 꺼내와 결과문에 추가한다

        else if(str.equals("size"))
        {
            sb.append(stack.size()).append("\n");
        }

입력받은 문자열이 size일 경우 stack의 크기를 size() 메소드를 통해 계산하고 결과문에 추가한다

        else if(str.equals("empty"))
        {
            if(stack.isEmpty())
            {
                sb.append("1\n");
            }
            else
            {
                sb.append("0\n");
            }
        }

입력받은 문자열이 empty일 경우 isEmpty() 메소드를 통해 스택이 비었는지 검사하고 비었다면 1, 비어있지 않다면 0을 결과문에 추가한다

        else if(str.equals("top"))
        {
            if(stack.isEmpty())
            {
                sb.append("-1\n");
            }
            else
            {
                sb.append(stack.peek()).append("\n");
            }
        }

입력받은 문자열이 top일 경우 isEmpty() 메소드를 통해 스택이 비었는지 검사하고 비어있다면 -1을, 비어있지 않다면
스택의 가장 위에 있는 요소를 가져와(삭제되지 않음) 결과문에 추가한다.

    bw.write(sb.toString());
    bw.close();

결과문을 출력한다