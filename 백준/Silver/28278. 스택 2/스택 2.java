import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder output = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++){
            String input = sc.next();
//            String splitInput = null;
//            if(input.contains(" ")){
//                splitInput = input.split(" ")[1];
//                input = input.split(" ")[0];
//            }

            switch(input){
                case "1":
                    String X = sc.next();
                    stack.push(Integer.parseInt(X));
                    break;
                case "2":
                    if(stack.isEmpty()) output.append("-1\n");
                    else output.append(stack.pop()+"\n");
                    break;
                case "3":
                    output.append(stack.size()+"\n");
                    break;
                case "4":
                    if(stack.isEmpty()){
                        output.append(1+"\n");
                    }else{
                        output.append(0+"\n");
                    }
                    break;
                case "5":
                    if(stack.isEmpty()) output.append(-1+"\n");
                    else output.append(stack.peek()+"\n");
                    break;
            }
        }

        System.out.println(output.toString());
    }




}
