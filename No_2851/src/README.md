# 문제

---

10개의 숫자를 순서대로 10번 입력받아 입력받은 순서대로 더한 값이 100과 가장
가까운 값이 되도록 하는 문제.

# 풀이

----

먼저 10개의 숫자를 입력받아 int 배열의 참조변수 mush에 저장한다.

    for(int i = 0; i < mush.length; i++)
    {
        do{
            mush[i] = Integer.parseInt(bf.readLine());
        }while(mush[i] < 1 || mush[i] > 100);
    }

그 후 순서대로 더할 때 이전에 더한 값 pre 의 100과의 차이가
이후에 더한 값 post 의 100과의 차이보다 작아질 때의 pre의 값이 100과
가장 가까운 값이 된다.

우선 post의 값을 mush[0]으로 초기화 한 뒤

    do{
        pre = post;
        post = pre + mush[count];
        count++;
        if(count == 10)
        {
            if(Math.abs(pre - 100) > Math.abs(post - 100))
            {
                pre = post;
            }

            break;

        }
    }while(Math.abs(pre - 100) > Math.abs(post - 100));

위의 코드에서 조건(pre의 100과의 차이가 post의 100과의 차이보다 큼)을 만족할
경우 다음 시행에서 post는 pre가 되므로

    pre = post;

를 수행한 뒤 pre에 mush[count] (count는 1부터 시작하여 반복문 시행 시마다 1씩 증가)
의 값을 더한 값이 post의 값이 된다.

만약 count가 10일 경우 모든 수를 더한 것이 되므로 pre와 post중 어느 값을
사용할 것인지를 정한 뒤 반복문을 빠져나간다.

그 후 두 값이 같은 절댓값을 가질 경우 큰 값을 사용해야 하므로

    if(Math.abs(pre - 100) == Math.abs(post - 100))
    {
        pre = post;
    }

위의 코드를 이용하여 검사한 뒤 pre의 값에 post의 값을 대입한다.

마지막으로 pre의 값을 출력한다.

    bw.write("" + pre);


