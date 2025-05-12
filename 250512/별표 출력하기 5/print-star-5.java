import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=N;i>0;i--){
            for(int k=0;k<i;k++){
                for(int j=0;j<i;j++){
                    System.out.print("*");
                }
                System.out.print(" ");
            }
            
            System.out.println();
        }
    }
}