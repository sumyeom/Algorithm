import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int[] input = new int[3];
        for(int i=0;i<3;i++){
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);
        System.out.println(input[1]);
    }
}