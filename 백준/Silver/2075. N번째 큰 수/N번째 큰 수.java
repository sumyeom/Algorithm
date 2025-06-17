import java.util.*;
public class Main{
    public static void main(String[] args){
        //System.out.println(solution(new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5},3,5));
        Scanner sc = new Scanner(System.in);
        int inputN = sc.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<inputN;i++){
            for(int j=0;j<inputN;j++){
                int num = sc.nextInt();
                queue.offer(num);
            }
        }
        int cnt=0;
        while(!queue.isEmpty() && cnt<inputN-1){
            queue.poll();
            cnt++;
        }

        System.out.println(queue.peek());


    }


}