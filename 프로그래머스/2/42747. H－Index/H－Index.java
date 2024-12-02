import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        if(citations[0]>citations.length){
            return citations.length;
        }
        int cnt = 0;
        int h = 0;
        for(int i=citations[citations.length-1];i>=0;i--){
            cnt = 0;
            for(int j=citations.length-1;j>=0;j--){
                if(i<=citations[j]){
                    cnt++;
                }
                if(cnt >= i) break;
            }
            if(cnt >= i){
                h = Math.max(h,i);
            }
        }
        return h;
    }
}