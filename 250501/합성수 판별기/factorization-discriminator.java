import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        boolean flag = false;
        for(int i=2;i<n;i++){
            if(n%i==0){
                System.out.println("C");
                flag = true;
                break;
            }
        }

        if(!flag){
            System.out.println("N");
        }
    }
}