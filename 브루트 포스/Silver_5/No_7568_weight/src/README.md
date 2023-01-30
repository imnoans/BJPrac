# 문제

---

사용자로부터 사람의 수 head를 입력받은 후 각 사람의 몸무게, 키를 순서대로 입력받아
저장한다. 그 후 각 사람의 등수를 구한다. 여기서 등수는 자신보다 덩치가 큰 사람의 수 + 1이다.
덩치가 큰지에 대한 판단은 몸무게와 키 모두가 그 사람보다 클 때 덩치가 크다고 간주한다.

이 때 각 사람의 등수를 출력한다.

# 풀이

---

우선 몸무게와 키를 저장할 class Wh를 정의한다.

Wh의 속성은 weight, height, rank 이다.

    public int weight;

    public int height;

    public int rank;

Wh 객체를 생성할 때는 height, weight를 입력받는다. rank는 1을 기본값으로 가진다.

    public Wh(int weight, int height)
    {
        this.weight = weight;
        this.height = height;
        this.rank = 1;
    }

해당 인물의 rank를 구하기 위한 method calRank를 정의한다.
키와 몸무게 모두가 큰 사람이 있을 경우 rank가 1 증가한다.

    public void calRank(Wh other)
    {
        if(this.weight < other.weight && this.height < other.height)
        {
            this.rank++;
        }
    }

main으로 돌아와서 우선 사람의 수 head를 사용자로부터 입력받는다.
사람의 수만큼 해당 인물의 등수를 저장할 int 배열 ranked를 생성한다.

    int head = Integer.parseInt(br.readLine()); 
    int[] ranked = new int[head];

head 수 만큼 weight와 height를 입력받아 Wh 객체를 생성한 뒤 ArrayList<Wh> heads에 저장한다.

    ArrayList<Wh> heads = new ArrayList<>();
    for(int i = 0; i < head; i++)
    {
        StringTokenizer swh = new StringTokenizer(br.readLine());
        w = Integer.parseInt(swh.nextToken());
        h = Integer.parseInt(swh.nextToken());
        heads.add(new Wh(w, h));
    }

heads에서 0번째 인덱스를 제거해가며 Wh who에 임시로 저장한다.

who 와 heads에 남아있는 Wh 객체들을 calRank()를 통하여 rank를 계산한 뒤 ranked에 각각 저장한다.

    for(int i = 0; i < head; i++)
    {
        who = heads.remove(0);
        for(Wh j : heads)
        {
            who.calRank(j);
            j.calRank(who);
        }
        ranked[i] = who.rank;
    }

마지막으로 ranked의 담겨있는 각 사람의 rank 정보를 출력한다.

    for(int i : ranked)
    {
        sb.append(i + " ");
    }

    bw.write(sb.toString());
    bw.close();