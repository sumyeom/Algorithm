import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            for(char ch : s.toCharArray()){

                if(stack.empty()){
                    stack.push(ch);
                    continue;
                }
                if(ch==']' && stack.peek() == '['){
                    stack.pop();

                    continue;
                }else if(ch == ')' && stack.peek() == '('){
                    stack.pop();
                    continue;
                }else if(ch == '}' && stack.peek() == '{'){
                    stack.pop();
                    continue;
                }

                stack.push(ch);

            }
            if(stack.isEmpty()){
                answer++;
            }
            String culS = s.substring(0,1);
            s = s. substring(1, s.length()) + culS;
            stack.removeAllElements();
        }
        return answer;
    }
}