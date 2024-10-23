import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        ArrayList<Character> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(list.contains((char)s.charAt(i))==true){
                int index = s.lastIndexOf((char)s.charAt(i),i-1);
                System.out.println("i = "+i+", index = "+index);
                answer[i] = i - index; 
            }
            else{
                list.add((char)s.charAt(i));
                answer[i] = -1;
            }
        }
        return answer;
    }
}