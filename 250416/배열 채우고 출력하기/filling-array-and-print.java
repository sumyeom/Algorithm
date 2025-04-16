import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        char[] charArr = new char[10];
        for(int i=0;i<10;i++){
            charArr[i] = sc.next().charAt(0);
        }

        for(int i=9;i>=0;i--){
            System.out.print(charArr[i]);
        }
    }
}