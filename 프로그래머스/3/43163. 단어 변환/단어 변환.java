import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
         answer = dfs(begin, target, words);
        return answer;
    }
     public int dfs(String begin, String target, String[] words){
        boolean[] visited = new boolean[words.length];
        int[] counter = new int[words.length];
        int[] answer = new int[words.length];
        if(begin.equals(words[0])){
            answer[0] = -1;
        }
        Queue<WordIndex> queue = new LinkedList<>();

        queue.add(new WordIndex(begin,0));

        while(!queue.isEmpty()){
            WordIndex current = queue.poll();
            String currentWord = current.word;
            int currentIndex = current.index;

            int cnt = 0;
            int max = 0;
            // 얼마나 같은지 구하기
            for(int i=0;i<counter.length;i++){
                counter[i] = 0;
            }
            for(int i=0;i<words.length;i++){
                if(visited[i]){
                    continue;
                }
                for(int j=0;j<words[i].length();j++){
                    if(words[i].charAt(j) == currentWord.charAt(j)){
                        cnt++;
                    }
                }
                counter[i] = cnt;
                max = counter[i];
                cnt=0;
            }
            // 방문함
            int index = 0;
            for(int i=0;i<counter.length;i++){
                if(max <= counter[i]){
                    index = i;
                    max = counter[i];
                }
            }
            if(!visited[index]){
                visited[index] = true;
                answer[index] = answer[currentIndex]+1;
                queue.add(new WordIndex(words[index],index));
            }
            if(currentWord.equals(target)){
                return answer[currentIndex];
            }
        }

        return 0;
    }

    public class WordIndex{
        String word;
        int index;

        public WordIndex(String begin, int i) {
            this.word = begin;
            this.index = i;
        }
    }
}