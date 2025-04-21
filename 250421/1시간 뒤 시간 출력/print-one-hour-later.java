import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        String[] split = S.split(":");

        int h = Integer.parseInt(split[0]) + 1;
        System.out.println(h+":"+split[1]);
    }
}