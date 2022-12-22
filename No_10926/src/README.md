#문제

단순히 입력한 문자열 뒤에 ??!를 추가하여 출력하는 문제이다.

#문제에 맞다고 생각되는 코드

다만 주어진 문제에서는 이전에 존재하던 ID일 경우에만 ??!를 추가하여 놀람을
표시한다고 했는데 이전에 있는 ID와 관계 없이 단순히 ??!를 추가하는 것은 
목적에 맞지 않다고 생각한다. 따라서 기존 ID를 위하여 pre_ID라는 ArrayList를 
추가하고 입력 예시에 있던 "joonas"와 "baekjoon"을 추가하였다. 그 후 contains를
통하여 기존과 비교하여 있다면 ??!를 추가하여 출력하고 없다면 pre_ID에 추가해야 
문제에 맞다고 생각한다.

    Scanner sc = new Scanner(System.in);
    String new_ID;
    ArrayList<String> pre_ID = new ArrayList<String>();
    pre_ID.add("joonas");
    pre_ID.add("baekjoon");

    do
    {
    new_ID = sc.next();
    }while ((new_ID.length() > 50));

    if(pre_ID.contains(new_ID))
    {
        System.out.println(new_ID + "??!");
    }
    else
    {
        pre_ID.add(new_ID);
    }