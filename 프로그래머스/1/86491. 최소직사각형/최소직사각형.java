class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        System.out.println(sizes.length);
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][0]<sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        int maxW=sizes[0][0];
        int maxH=sizes[0][1];
        for(int i=0;i<sizes.length;i++){
            if(maxW < sizes[i][0]){
                maxW = sizes[i][0];
            }
            if(maxH < sizes[i][1]){
                maxH = sizes[i][1];
            }
        }
        answer = maxW * maxH;
        return answer;
    }
}