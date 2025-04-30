import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0;
        int b = 0;
        int c = 0;
        for(int i=1;i<=n;i++){
            if(i%2==0){
                if(i%12==0){
                    c++;
                }else if(i%3==0){
                    b++;
                }else{
                    a++;
                }
            }else if(i%3==0){
                if(i%12==0){
                    c++;
                }else{
                    b++;
                }
            }else if(i%12==0){
                c++;
            }

        }

        System.out.print(a+ " " + b + " " + c);
    }
}