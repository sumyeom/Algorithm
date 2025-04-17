import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int num=-1;
        while(num != 0){
            num = sc.nextInt();
            if(num == 0){
                break;
            }
            System.out.println(num);
        }
    }
}