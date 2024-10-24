class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int receiveCola = 0;
        int remainCola = 0;

        int tempN = n;
        
        while(true){
            if((tempN + remainCola >= a) && tempN < a){
                receiveCola = ((tempN + remainCola) / a) * b;
                int tempremainCola = remainCola;
                remainCola = 0;
                remainCola += (tempN + tempremainCola) % a;
                System.out.println("receive2= "+receiveCola);
                System.out.println("remain2 = "+remainCola);
                tempN = receiveCola; 
                answer += receiveCola;
                System.out.println("tempN = "+tempN);
            }else if(tempN + remainCola < a){
                break;
            }
            receiveCola = (tempN/a) * b;
            remainCola += tempN%a;
            System.out.println("receive1 = "+receiveCola);
            System.out.println("remain1 = "+remainCola);
            if(receiveCola == 0 && remainCola <a){
                break;
            }
            
            answer += receiveCola;
            tempN = receiveCola; 
            System.out.println("tempN = "+tempN);
            
        }
        
        return answer;
    }
}