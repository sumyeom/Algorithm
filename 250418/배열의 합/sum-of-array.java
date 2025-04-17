import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int[][] cnt = new int[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                cnt[i][j] = sc.nextInt();
            }
        }

       
        for(int i=0;i<4;i++){
            int total = 0;
            for(int j=0;j<4;j++){
                total += cnt[i][j];
            }
            System.out.println(total);
        }
    }
}