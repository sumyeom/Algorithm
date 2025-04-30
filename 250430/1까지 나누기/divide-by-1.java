import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;

        while(true){
            n = n/i;
            if(n <= 1){
                System.out.println(i);
                break;
            }
            i++;
        }
        
    }
}