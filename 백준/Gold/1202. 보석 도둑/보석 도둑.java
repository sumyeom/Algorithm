import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        List<Jewelry> jewelryList = new ArrayList<>();

        for(int i = 0; i < N; i++){
            int M = sc.nextInt();
            int V = sc.nextInt();
            jewelryList.add(new Jewelry(M, V));
        }

        Collections.sort(jewelryList, (j1, j2) -> {
            if(j1.m != j2.m) return Integer.compare(j1.m, j2.m);
            return Integer.compare(j1.v, j2.v);
        });

        List<Integer> bagList = new ArrayList<>();
        for(int i = 0; i < K; i++){
            bagList.add(sc.nextInt());
        }
        Collections.sort(bagList);

        int index = 0;
        long answer = 0;

        PriorityQueue<Jewelry> jewelries = new PriorityQueue<>((j1, j2) -> Integer.compare(j2.v, j1.v));

        for(int i = 0; i < K; i++){
            while(index < N && jewelryList.get(index).m <= bagList.get(i)){
                jewelries.offer(jewelryList.get(index++));
            }

            if(!jewelries.isEmpty()){
                answer += jewelries.poll().v;
            }
        }

        System.out.println(answer);
    }

    public static class Jewelry {
        int m, v;
        public Jewelry(int m, int v){
            this.m = m;
            this.v = v;
        }
    }
}
