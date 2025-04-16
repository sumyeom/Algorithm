import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        System.out.println(input.substring(0,1)+"a"+input.substring(2,input.length()-2)+"a"+input.substring(input.length()-1));
    }
}