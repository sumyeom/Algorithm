import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int gop = 1;
        for(int i=1;i<=10;i++){
            gop*=i;
            if(gop>=n){
                System.out.println(i);
                break;
            }
        }
    }
}