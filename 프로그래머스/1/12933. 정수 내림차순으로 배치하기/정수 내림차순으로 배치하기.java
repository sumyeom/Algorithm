import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        String strN = String.valueOf(n);
        ArrayList<Integer> list = new ArrayList<>();
        for(char ch : strN.toCharArray()){
            list.add(Character.getNumericValue(ch));
        }
        Collections.sort(list);
        strN = "";
        for(int i=list.size()-1;i>=0;i--){
            strN += list.get(i);
        }
        return Long.parseLong(strN);
        
    }
}