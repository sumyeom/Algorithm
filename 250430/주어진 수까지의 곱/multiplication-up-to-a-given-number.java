import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int gop = 1;
        for(int i=a;i<=b;i++){
            gop*=i;
        }

        System.out.println(gop);
    }
}