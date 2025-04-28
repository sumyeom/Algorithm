import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if(input.equals("S")){
            System.out.println("Superior");
        }else if(input.equals("A")){
            System.out.println("Excellent");
        }else if(input.equals("B")){
            System.out.println("Good");
        }else if(input.equals("C")){
            System.out.println("Usually");
        }else if(input.equals("D")){
            System.out.println("Effort");
        }else{
            System.out.println("Failure");
        }
    }
}