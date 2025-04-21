import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();

        String[] split = S.split("-");

        System.out.println(split[0]+split[1]);
    }
}