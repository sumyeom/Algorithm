import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        ArrayList<Integer> people = new ArrayList<>();
        double sqrt = Math.sqrt(number);
        
        for(int i=1;i<=number;i++){
            int yak=0;
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    yak++;
                    if (j != i / j) {
                        yak++;
                    }
                }
             }
            people.add(yak);
        }
        
        
        System.out.println(people.size());
        for(int i=0;i<people.size();i++){
            System.out.println(people.get(i));
            if(people.get(i) > limit){
                answer += power;
            }else{
                answer += people.get(i);
            }
            
        }
        return answer;
    }
}