import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        boolean flag = false;
        for(int i=a;i<=b;i++){
            if(1920%i ==0 && 2880%i==0){
                flag = true;
                break;
            }
        }

        if(flag){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}