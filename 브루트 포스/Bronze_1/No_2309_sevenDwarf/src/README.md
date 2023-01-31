# 문제

---

9개의 숫자 중 2개의 숫자를 골라서 빼면 100이 나오는 경우 그 두수를 제외한 나머지
수를 오름차순으로 출력하는 문제.

# 풀이

---

우선 두 수를 저장하기 위한 a, b와 100에서 넘치는 수를 저장하기 위한 count,
두 수의 합을 저장하기 위한 sum을 정의한다.

    int a, b, sum = 0, count = 0;

난쟁이들을 저장하기 위한 ArrayList<Integer> dwarf를 정의한다.

    ArrayList<Integer> dwarf = new ArrayList<>();

9개의 수를 받아 dwarf에 저장하고 count를 증가시킨다.

    for(int i = 0; i < 9; i++)
    {
        a = Integer.parseInt(br.readLine());
        dwarf.add(a);
        count += a;
    }

dwarf에 들어있는 수를 정렬한다.

    Collections.sort(dwarf);

100에서 넘치는 수를 count에 저장한다.

    count -= 100;

두개의 서로 다른 수를 더해 count와 같은 경우 dwarf에서 제거한 후 for 문을 종료한다.

    for(int i = 0; i < 8; i++)
    {
        a = dwarf.get(i);
        for(int j = i + 1; j < 9; j++)
        {
            b = dwarf.get(j);
            sum = a + b;

            if(sum == count)
            {
                dwarf.remove(j);
                dwarf.remove(i);
                break;
            }

        }
        if(sum == count)
        {
            break;
        }

    }

dwarf에 남아있는 수를 출력한다.

    for(int i : dwarf)
    {
        sb.append(i + "\n");
    }

    bw.write(sb.toString());
    bw.close();