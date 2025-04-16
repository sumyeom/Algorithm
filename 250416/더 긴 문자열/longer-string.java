import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        String inputA = sc.next();
        String inputB = sc.next();

        if(inputA.length() > inputB.length()){
            System.out.println(inputA + " " + inputA.length());
        }else if(inputA.length() < inputB.length()){
            System.out.println(inputB + " " + inputB.length());
        }else{
            System.out.println("same");
        }
    }
}