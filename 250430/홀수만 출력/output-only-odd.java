import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        for(int i = A ; i<=B ;i++){
            if(i%2==1){
                System.out.print(i + " ");
            }
        }
    }
}