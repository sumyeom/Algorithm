import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int a = sc.nextInt();

        if(a >= 19){
            if(s == 0){
                System.out.println("MAN");
            }else{
                System.out.println("WOMAN");
            }
        }else{
            if(s == 0){
                System.out.println("BOY");
            }else{
                System.out.println("GIRL");
            }
        }

    }
}