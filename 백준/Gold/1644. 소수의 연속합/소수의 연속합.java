
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N==1) {
            System.out.println(0);
            return;
        }
        List<Integer> list = new ArrayList<>();
        for(int num=2;num<=N;num++) {
            boolean flag = true;
            for(int i=2;i*i<=num;i++){
                if(num%i==0){
                    flag = false;
                    break;
                }
            }
            if(flag) {
                list.add(num);
            }
        }

        int left = 0;
        int right = 0;
        int answer = 0;
        int sum = list.get(0);
        while(right<list.size()) {
            if(sum == N){
                answer++;
                sum-=list.get(left++);
            }else if(sum< N){
                right++;
                if(right<list.size()) {
                    sum+=list.get(right);
                }
            }else{
                sum-=list.get(left++);
            }
        }
        System.out.println(answer);
    }

}