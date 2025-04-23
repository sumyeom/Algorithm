import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] split = input.split("-");

        System.out.println(split[0] + "-" +split[2]+"-"+split[1]);
    }
}