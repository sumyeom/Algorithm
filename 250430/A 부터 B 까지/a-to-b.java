import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for(int i=a;i<=b;){
            System.out.print(i+" ");
            if(i%2==1){
                i*=2;
            }else{
                i+=3;
            }
        }
    }
}