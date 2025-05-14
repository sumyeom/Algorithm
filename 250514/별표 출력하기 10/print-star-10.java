import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a = 1;
        int b = N;
        for(int i=1;i<=N;i++){
            if(i%2!=0){
                for(int j=0;j<a;j++){
                    System.out.print("* ");
                }
                a++;
            }else{
                for(int j=b;j>0;j--){
                    System.out.print("* ");
                }
                b--;
            }
            System.out.println();
        }
        
        a--;
        b++;

        
        for(int i=1;i<=N;i++){
            if(N%2==0){
                if(i%2!=0){
                for(int j=0;j<b;j++){
                        System.out.print("* ");
                    }
                    b++;
                }else{
                    for(int j=a;j>0;j--){
                        System.out.print("* ");
                    }
                    a--;
                }
            }
            

            if(N%2!=0){
                if(i%2!=0){
                    for(int j=a;j>0;j--){
                        System.out.print("* ");
                    }
                    a--;
                }else{
                    for(int j=0;j<b;j++){
                        System.out.print("* ");
                    }
                    b++;
                }
            }
            System.out.println();
        }
    }
}