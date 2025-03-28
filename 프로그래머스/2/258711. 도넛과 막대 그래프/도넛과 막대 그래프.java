import java.util.*;
class Solution {
    static int start = 0;
    static int doughnut = 0;
    static int stick = 0;
    static int eight = 0;
    static boolean[] visited;

    public static int[] solution(int[][] edges) {
        int[] answer = new int[4];
        Map<Integer, Node> nodeMap = new HashMap<>();
        int maxNode = 0;

        // 최대 노드 번호 찾기
        for (int[] edge : edges) {
            maxNode = Math.max(maxNode, Math.max(edge[0], edge[1]));
        }

        int[] inDegree = new int[maxNode + 1];  // 들어오는 간선 개수
        int[] outDegree = new int[maxNode + 1]; // 나가는 간선 개수
        visited = new boolean[maxNode + 1]; // 방문 여부

        for (int i = 1; i <= maxNode; i++) {
            nodeMap.put(i, new Node(i));
        }

        // 그래프 구성
        for (int[] edge : edges) {
            Node from = nodeMap.get(edge[0]);
            Node to = nodeMap.get(edge[1]);

            from.add(to);
            inDegree[edge[1]]++;
            outDegree[edge[0]]++;
        }

        // 시작 노드 찾기: 진입 차수가 0이고 진출 차수가 2 이상인 노드
        for (int i = 1; i <= maxNode; i++) {
            if (inDegree[i] == 0 && outDegree[i] >= 2) {
                start = i;
                break;
            }
        }

        // 예외처리: 시작 노드가 존재하지 않으면 오류 방지
        if (start == 0 || !nodeMap.containsKey(start)) {
            return new int[]{0, 0, 0, 0};
        }

        Node startNode = nodeMap.get(start);

        // 각 서브 그래프 탐색 (DFS)
        for (Node child : startNode.child) {
            if (!visited[child.number]) {
                checkGraph(child);
            }
        }

        answer[0] = start;
        answer[1] = doughnut;
        answer[2] = stick;
        answer[3] = eight;
        return answer;
    }

    public static void checkGraph(Node startNode) {
        Set<Integer> path = new HashSet<>();
        int cycleCount = detectCycles(startNode, path);

        if (cycleCount == 0) {
            stick++; // 막대 그래프
        } else if (cycleCount == 1) {
            doughnut++; // 도넛 그래프
        } else {
            eight++; // 8자 그래프
        }
    }

    private static int detectCycles(Node node, Set<Integer> path) {
        if (path.contains(node.number)) {
            return 1; // 사이클 발견
        }

        if (visited[node.number]) {
            return 0; // 이미 방문한 노드는 추가 탐색 안 함
        }

        visited[node.number] = true;
        path.add(node.number);

        int cycleCount = 0;
        Iterator<Node> iterator = node.child.iterator();
        while (iterator.hasNext()) {
            cycleCount += detectCycles(iterator.next(), path);
        }

        path.remove(node.number); // 백트래킹

        return cycleCount;
    }

    public static class Node {
        int number;
        List<Node> child = new ArrayList<>();

        Node(int number) {
            this.number = number;
        }

        void add(Node addNode) {
            this.child.add(addNode);
        }
    }
}