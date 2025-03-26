class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        // 출근 인정 시각 저장
        int[] schedulesPass = new int[schedules.length];

        for(int i=0;i<schedules.length;i++){
            if(schedules[i] % 100 >= 50){
                schedulesPass[i] = schedules[i] + 100 - 50;
            }else{
                schedulesPass[i] = schedules[i] + 10;
            }
        }

        // 직원들 출근 시간 보면서 인정 시간안에 들어왔는지 확인
        // 시작 요일이 언젠지 확인 및 주말은 미포함 해야됨
        // startday 계속 증가하면서 판단해야 돼서 복사할 변수 필요

        for(int i=0;i<timelogs.length;i++){
            // 중간에 지각 하면 false 처리할 boolean 변수 선언 필요
            boolean lateCheck = true;
            int copyStartday = startday;
            for(int j=0;j<timelogs[i].length;j++){
                // 주말일땐 패스
                if(copyStartday == 6 || copyStartday ==7){
                    copyStartday++;
                    if(copyStartday > 7){
                        copyStartday -= 7;
                    }
                    continue;
                }
                // 출근 인정 시간 보다 늦게 출근 했다면 false 처리
                if(timelogs[i][j] > schedulesPass[i]){
                    lateCheck = false;
                    break;
                }
                copyStartday++;
                if(copyStartday > 7){
                    copyStartday -= 7;
                }
            }
            if(lateCheck){
                answer++;
            }
        }

        return answer;
    }
}