import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        Set<Integer> numSet = new HashSet<>();
        generatePrime("",numbers,numSet);
        for(Integer i : numSet) {
            if(isPrime(i)) {
                answer++;
            }
        }
        return answer;
    }
    public void generatePrime(String number, String remainNumber, Set<Integer> numSet){
        if(!number.isEmpty()){
            numSet.add(Integer.parseInt(number));
        }
        for(int i=0;i<remainNumber.length();i++){
            generatePrime(number+remainNumber.charAt(i),remainNumber.substring(0,i)+remainNumber.substring(i+1),numSet);
        }
    }
    public boolean isPrime(int number) {
        if(number <2 ) return false;
        for(int i=2;i<=Math.sqrt(number);i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}