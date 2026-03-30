import java.util.*; 
class Solution {
    private static boolean isValidMove(int nx, int ny){
        return 0 <= nx && 0 <= ny && nx < 11 && ny < 11;
    }
    
    private static HashMap<Character, int[]> location = new HashMap<>();
    
    private static void initLocation(){
        location.put('U', new int[]{-1, 0});
        location.put('D', new int[]{1, 0});
        location.put('L', new int[]{0, -1});
        location.put('R', new int[]{0, 1});
    }
    
    
    public int solution(String dirs) {
        
        initLocation();
        
        int sx = 5, sy = 5;
        
        HashSet<String> answer = new HashSet<>(); 
        
        for(int i=0;i<dirs.length();i++){
            int[] offset = location.get(dirs.charAt(i));
            int nx = sx + offset[0];
            int ny = sy + offset[1];
            
            if(!isValidMove(nx,ny)) continue;
            
            answer.add(sx+" "+ sy + " "+ nx + " "+ ny);
            answer.add(nx+" "+ ny + " "+ sx + " "+ sy);
            sx = nx;
            sy = ny;
        }
        
        return answer.size() / 2;
    }
}