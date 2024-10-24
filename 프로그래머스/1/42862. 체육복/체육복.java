class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] clothes = new int[n];
        
        for(int i=0;i<n;i++){
            clothes[i] = 1;
        }
        for(int i=0;i<reserve.length;i++){
            clothes[reserve[i]-1]++;
        }
        for(int i=0;i<lost.length;i++){
            clothes[lost[i]-1]--;
        }
        
        for(int i=0;i<n;i++){
            if(clothes[i]==0){
                //앞에 볼라고했는데 첫번째인자이면?
                if(i-1<0){
                    //뒤에꺼 확인
                    if(clothes[i+1]==2){
                        clothes[i] = 1;
                        clothes[i+1] = 1;
                    }
                }
                else if(i+1 == n){
                    if(clothes[i-1]==2){
                        clothes[i] = 1;
                        clothes[i-1] = 1;
                    }
                }else{
                    if(clothes[i-1]==2){
                        clothes[i] = 1;
                        clothes[i-1] = 1;
                    }
                    else if(clothes[i+1]==2){
                        clothes[i] = 1;
                        clothes[i+1] = 1;
                    }else if(clothes[i]==2){
                        clothes[i] = 1;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            if(clothes[i] == 1 || clothes[i]==2){
                answer++;
            }
        }
        
        return answer;
    }
}