import org.w3c.dom.Node;

import java.beans.beancontext.BeanContext;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int N;
        int answer = 0;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        String buffer;
        buffer = sc.nextLine();
        for(int i=0;i<N;i++){
            String input = sc.nextLine();
            List<Character> list = new ArrayList<>();
            for(int j=0;j<input.length();j++){
                if(list.isEmpty()){
                    list.add(input.charAt(j));
                }else{
                    if(list.get(list.size()-1)!=input.charAt(j)){
                        boolean flag = true;
                        for(int l = 0;l<list.size();l++){
                            if (list.get(l) == input.charAt(j)) {
                                flag = false;
                                break;
                            }
                        }
                        if(flag){
                            list.add(input.charAt(j));
                        }else{
                            break;
                        }
                    }else{
                        list.add(input.charAt(j));
                    }
                }
            }
            if(list.size() == input.length()){
                answer++;
            }
        }
        System.out.print(answer);
    }


}
