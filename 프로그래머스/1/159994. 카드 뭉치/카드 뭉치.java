class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int[] int1 = new int[cards1.length];
        int[] int2 = new int[cards2.length];
        int index1=0;
        int index2=0;
        // goal 배열을 순회하며 cards1, cards2에서 일치하는지 확인
        for (int i = 0; i < goal.length; i++) {
            if (index1 < cards1.length && goal[i].equals(cards1[index1])) {
                index1++;
            } else if (index2 < cards2.length && goal[i].equals(cards2[index2]))            {
                index2++;
            } else {
                answer = "No";  // cards1이나 cards2에 없는 순서라면 "No"
                break;
            }
        }

        return answer;
    }
}