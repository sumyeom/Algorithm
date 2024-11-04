class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        //String[] wallpaper1 = {"#.",".."};
        int minX=0, minY=0;
        int maxX=0, maxY=0;
        boolean flag = false;
        for(int i=0;i<wallpaper.length;i++){
            for(int j=0;j<wallpaper[i].length();j++){
                if(wallpaper[i].charAt(j)=='#'){
                    minX = i;
                    minY = j;
                    maxX = i;
                    maxY = j;
                    flag = true;
                    break;
                }
            }
            if(flag == true) break;
        }
        int tempX = maxX;
        int tempY = maxY;
        
        for(int i=0;i<wallpaper.length;i++){
            for(int j=0;j<wallpaper[i].length();j++){
                if(wallpaper[i].charAt(j)=='#'){
                    if(minX >= i) minX = i;
                    if(minY >= j) minY = j;
                    if(tempX <= i) {
                        maxX = i+1;
                        tempX = i;
                    }
                    if(tempY <= j) {
                        maxY = j+1;
                        tempY = j;
                        System.out.println("j="+j);
                    }
                    
                }
            }
        }
        //if(maxX == wallpaper1.length - 1) maxX++;
        //if(maxY == wallpaper[0].length() -1 ) maxY++;
        answer[0] = minX;
        answer[1] = minY;
        answer[2] = maxX;
        answer[3] = maxY;
        return answer;
    }
}