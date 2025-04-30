import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        int first = a/b;
        sb.append(first);

        sb.append(".");
        int second = a%b;
        for(int i=0;i<20;i++){
            second *=10;
            int num = second / b;
            sb.append(num);
            second %= b;
        }

        System.out.println(sb.toString());
    }
}