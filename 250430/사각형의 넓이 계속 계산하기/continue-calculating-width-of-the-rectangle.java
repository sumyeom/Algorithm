import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        while(true){
            int h = sc.nextInt();
            int w = sc.nextInt();
            char c = sc.next().charAt(0);
            System.out.println(h*w);
            if(c=='C'){
                break;
            }

        }
        
    }
}