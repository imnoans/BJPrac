# 문제

_______
3개의 주사위 값을 입력받아 같은 수가 나온 갯수에 따라 상금을 계산하여 지급하는 문제.

# 풀이

_______
    for (int i = 0; i < dice.length; i++)
    {
        do
        {
        dice[i] = sc.nextInt();
        }while(dice[i] < 1 || dice[i] > 6);
    }

위 코드를 통하여 3개의 주사위 값을 입력받은 뒤 저장한다.
주사위의 값의 범위는 1 ~ 6이므로 범위를 벗어나는 값을 입력시 다시
입력받는다.

    max = dice[0];

가장 큰 값을 비교하기 위하여 max를 dice[0]로 초기화시킨다.

    if(dice[0] == dice[1] && dice[1] == dice[2])
        {
            result = 10000 + dice[0] * 1000;
        }
        else if(dice[0] == dice [1])
        {
            result = 1000 + dice[0] * 100;
        }
        else if(dice[1] == dice[2])
        {
            result = 1000 + dice[1] * 100;
        }
        else if(dice[0] == dice[2])
        {
            result = 1000 + dice[0] * 100;
        }
        else
        {
            for(int i = 0; i < dice.length; i++)
            {
                if(max < dice[i])
                {
                    max = dice[i];
                }
            }
            result = max * 100;
        }

위 코드를 통하여 각각의 경우에 수에 따른 상금을 계산한다.