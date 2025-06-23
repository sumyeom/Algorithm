import java.util.*;
public class Solution {
        public int solution(int[][] points, int[][] routes) {
            int answer = 0;

            // 포인트 위치
            Map<Integer, int[]> map = new HashMap<>();
            for(int i=0;i<points.length;i++){
                map.put(i, new int[]{points[i][0], points[i][1]});
            }

            // 시간별 위치
            Map<Integer, Map<String, Integer>> robotPosition = new HashMap<>();

            // 로봇별로
            for(int[] route : routes){
                int time=0;
                // 현재 위치는 처음꺼니까 먼저 저장
                int[] current = map.get(route[0]-1);
                RecordRoute(time++, current, robotPosition);
                //로봇의 이동경로
                for(int i=1;i<route.length;i++){
                    int[] next = map.get(route[i]-1); // 포인트 번호 받아서 다음으로 가야됨

                    // r위치 먼저
                    // while문으로 같아질때까지 돌리면서 시간별로 위치 저장해야됨
                    while(true){
                        if(current[0] == next[0]){
                            break;
                        }
                        current = new int[]{current[0] + (current[0] < next[0] ? 1 : -1), current[1]};
                        RecordRoute(time++, current, robotPosition);

                    }

                    // c 위치
                    while(true){
                        if(current[1] == next[1]){
                            break;
                        }
                        current = new int[]{current[0], current[1] + (current[1] < next[1] ? 1 : -1)};
                        RecordRoute(time++, current, robotPosition);

                    }


                }

            }

            for(Map<String, Integer> position : robotPosition.values()){
                for(int cnt : position.values()){
                    if(cnt>=2) answer ++;
                }
            }
            return answer;
        }

        public static void RecordRoute(int time, int[] current, Map<Integer, Map<String, Integer>> robotPosition){
            robotPosition.putIfAbsent(time, new HashMap<>());
            String str = current[0] + "," + current[1];
            Map<String, Integer> tmp = robotPosition.get(time);
            tmp.put(str, tmp.getOrDefault(str,0)+1);
        }
}