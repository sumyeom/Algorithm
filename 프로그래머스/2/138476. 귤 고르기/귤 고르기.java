import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        // 1. 귤 크기별 빈도 계산
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int size : tangerine) {
            countMap.put(size, countMap.getOrDefault(size, 0) + 1);
        }

        // 2. 빈도수를 리스트로 추출하고 내림차순 정렬
        List<Integer> frequencies = new ArrayList<>(countMap.values());
        frequencies.sort(Collections.reverseOrder());

        // 3. 최소한의 크기로 k개 선택
        int total = 0;
        int kinds = 0;
        for (int frequency : frequencies) {
            total += frequency;
            kinds++;
            if (total >= k) {
                break;
            }
        }

        return kinds;
    }
}