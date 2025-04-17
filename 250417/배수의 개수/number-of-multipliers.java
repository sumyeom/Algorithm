import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];
        int three = 0;
        int five = 0;
        for(int i=0;i<10;i++){
            arr[i] = sc.nextInt();
            if(arr[i] % 3 == 0){
                three++;
            }
            if(arr[i] % 5 == 0){
                five++;
            }
        }

        System.out.println(three + " " + five);
    }
}