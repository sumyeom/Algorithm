import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int aAge = sc.nextInt();
        char aGender = sc.next().charAt(0);
        int bAge = sc.nextInt();
        char bGender = sc.next().charAt(0);

        if((aAge >= 19 && aGender == 'M') || (bAge>=19 && bGender == 'M')){
            System.out.println(1);
        }
    }
}