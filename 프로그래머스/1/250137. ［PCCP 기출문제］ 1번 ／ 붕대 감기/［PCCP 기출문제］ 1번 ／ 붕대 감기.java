// t초 동안 붕대 감으면 1초마다 x만큼 체력 회복
// t초 연속으로 붕대 감는거 성공하면 y만큼의 체력 추가 회복
// 최대 체력 존재, 현재 체력이 최대 체력보다 커지는것 불가

// 기술 쓰다가 공격 당하면 기술 취소, 공격당하면 체력 회복 불가
// 공격당해서 기술 취소 or 기술 끝나면 붕대감기 사용 -> 연속 사용 시간이 0으로 초기화

// 공격받으면 정해진 피해량 만큼 현재 체력 줄어듦
// 0 이하가 되면 쥬금! 체력 회복 불가능

// 붕대 감기 기술의 정보, 캐릭터 최대 체력, 공격패턴 

// bandage : 붕대 감기 기술 시전 시간, 1초당 회복량, 추가 회복량
// health : 최대 체력
// attacks : 몬스터의 공격시간과 피해량

// [5, 1, 5] 30	[[2, 10], [9, 15], [10, 5], [11, 5]]	

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int index = 0;
        int currentHealth = health;
        int bandageTime = 0;
        for(int i=0;i<=attacks[attacks.length-1][0];i++){
            // 공격
            if(attacks[index][0]==i){
                currentHealth -= attacks[index][1];
                if(currentHealth <= 0){
                    answer = -1;
                    break;
                }
                
                bandageTime = 0;
                index++;
            }else{
                if(currentHealth >= health ){
                    continue;
                }else{
                    // 붕대감기
                    bandageTime++;
                    currentHealth += bandage[1];
                    if(bandageTime == bandage[0]){
                        currentHealth += bandage[2];
                        bandageTime = 0;
                    }
                    if(currentHealth >= health){
                        currentHealth = health;
                    }
                }
            }
            answer = currentHealth;
        }
        return answer;
    }
}



