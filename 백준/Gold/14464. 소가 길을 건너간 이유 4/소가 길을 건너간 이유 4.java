import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        int N = sc.nextInt();
        int answer = 0;
        long[] chickArr = new long[C];
        for(int i=0;i<C;i++){
            long num = sc.nextLong();
            chickArr[i] = num;
        }

        Arrays.sort(chickArr);

        List<Cow> cowList = new ArrayList<>();
        for(int i=0;i<N;i++){
            long numA = sc.nextLong();
            long numB = sc.nextLong();
            cowList.add(new Cow(numA, numB));
        }

        cowList.sort((c1,c2)-> {
                if(c1.aj != c2.aj) return Long.compare(c1.aj, c2.aj);
                return Long.compare(c1.bj, c2.bj);
        });


        PriorityQueue<Cow> cowQueue = new PriorityQueue<>((c1,c2)-> {
            return Long.compare(c1.bj, c2.bj);
        });

        int cowIndex = 0;
        for(int i=0;i<C;i++){
            long t = chickArr[i];

            while(cowIndex < N && cowList.get(cowIndex).aj<=t){
                cowQueue.offer(cowList.get(cowIndex++));
            }

            //bj이 t보다 작으면 없애야됨
            while(!cowQueue.isEmpty() && cowQueue.peek().bj < t){
                cowQueue.poll();
            }


            if(!cowQueue.isEmpty()){
                cowQueue.poll();
                answer++;
            }

        }

        System.out.println(answer);

    }

    public static class Cow{
        long aj;
        long bj;
        public Cow(long aj, long bj){
            this.aj = aj;
            this.bj = bj;
        }
    }
}