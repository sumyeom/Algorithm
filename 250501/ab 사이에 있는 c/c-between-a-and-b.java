import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        boolean flag = false;
        for(int i=a;i<=b;i++){
            if(i%c==0){
                System.out.println("YES");
                flag = true;
                break;
            }
        }
        if(!flag){
            System.out.println("NO");
        }


    }
}