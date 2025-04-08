import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char c = Character.toUpperCase(input.charAt(i));
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int max = Collections.max(map.values());
        char answer = '?';
        int count = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                count++;
                if (count == 1) {
                    answer = entry.getKey();
                } else {
                    answer = '?';
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
