import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int startX = 0;
        int startY = 0;
        
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[i].length();j++){
                if(park[i].charAt(j)=='S'){
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }
        Integer[][] dxy = {{-1,0},{1,0},{0,-1},{0,1}};
        Map<String, Integer[]> map = new HashMap<>();
        
        map.put("N",dxy[0]);
        map.put("S",dxy[1]);
        map.put("W",dxy[2]);
        map.put("E",dxy[3]);
        
        for(int i=0;i<routes.length;i++){
            String[] dir = routes[i].split(" ");
            boolean flag = false;
            int nextX = startX;
            int nextY = startY;
            for(int j=0;j<Integer.parseInt(dir[1]);j++){
                nextX = nextX + (map.get(dir[0])[0]) ;
                nextY = nextY + (map.get(dir[0])[1]) ;
                if(nextX < 0 || nextX >= park.length || nextY < 0 || nextY >= park[0].length()){
                    flag = false;
                    break;
                }
                if(park[nextX].charAt(nextY)=='O'){
                    flag = true;
                }else if(park[nextX].charAt(nextY)=='X'){
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                startX = nextX;
                startY = nextY;
            }
            
        }
        answer[0] = startX;
        answer[1] = startY;
        return answer;
    }
}