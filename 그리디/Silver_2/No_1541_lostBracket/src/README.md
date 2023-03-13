# 문제

----

세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.

그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.

괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

# 입력

---

첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다. 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.

# 출력

---

첫째 줄에 정답을 출력한다.

# 풀이

----

첫 번째 -가 나온 이후로는 +가 나오면 앞에 있는 -와 함께 괄호로 묶고 -가 나오면 새로운 괄호로 묶으면 되므로
모두 -연산으로 생각하면 된다.

-가 나오기 전까지의 값을 저장할 plusNumbers와 -가 나온 이후의 값을 저장할 minusNumbers를
생성한다.

각 연산자가 나오기 전까지의 값을 보관할 StringBuilder sb를 생성한다.

    int plusNumbers = 0;
    int minusNumbers = 0;
    StringBuilder sb = new StringBuilder();

 '-' 연산자가 나왔는지의 여부를 저장할 isMinus를 생성한다

    boolean isMinus = false;

식을 입력받아 target에 저장한다

    String target = br.readLine();

target을 char의 배열으로 변경하여 각 인덱스의 값마다 검사를 시행한다

    for(char c : target.toCharArray())
    {

앞에서 -가 나오지 않았다면 연산자가 나오기 전까지의 숫자들을 sb에 추가하고 
연산자가 나왔을 때는 int로 변환하여 plusNumbers에 더하는 것을 기본으로 하고
마이너스 연산자가 나왔을 경우 다음부터는 minus에 넣기 위해서 isMinus를 true로 변경한다.

        if(!isMinus)
        {
            if(Character.isDigit(c))
            {
                sb.append(c);
            }
            else if(c == '+')
            {
                plusNumbers += Integer.parseInt(sb.toString());
                sb.setLength(0);
            }
            else
            {
                plusNumbers += Integer.parseInt(sb.toString());
                sb.setLength(0);
                isMinus = true;
            }
        }

앞에서 -연산자가 나와 isMinus가 true 라면 연산자가 나오기 전까지 sb에 추가하고
연산자가 나오면 minusNumbers에 더한다.

        else
        {
            if(Character.isDigit(c))
            {
                sb.append(c);
            }
            else
            {
                minusNumbers += Integer.parseInt(sb.toString());
                sb.setLength(0);
            }
        }
    }

반복문이 끝난 후 sb에 남아 있는 수들은 -가 나왔다면 plus, 나오지 않았다면 minus에 더한다
    
    if(isMinus)
    {
        minusNumbers += Integer.parseInt(sb.toString());
    }
    else
    {
        plusNumbers += Integer.parseInt(sb.toString());
    }

plusNumbers에서 minusNumbers를 뺀 값을 출력한다

    bw.write("" + (plusNumbers - minusNumbers));
    bw.close();