import java.util.*;
class Solution {
    static int start = 0;
    static int doughnut = 0;
    static int stick = 0;
    static int eight = 0;
    static boolean[] visited;
    
    public static int[] solution(int[][] edges) {
        int[] answer = new int[4];
        List<Node> nodeList = new ArrayList<>();
        int length = 0;
        
        // find maximum node number (length of node list)
        for (int[] edge : edges) {
            length = Math.max(length, Math.max(edge[0], edge[1]));
        }

        // create nodes
        for (int i = 1; i <= length; i++) {
            nodeList.add(new Node(i));
        }

        // inDegree, outDegree for the graph
        int[] inDegree = new int[length + 1];
        int[] outDegree = new int[length + 1];
        visited = new boolean[length + 1];

        // graph construction
        for (int[] edge : edges) {
            Node from = nodeList.get(edge[0] - 1);
            Node to = nodeList.get(edge[1] - 1);

            from.add(to);
            inDegree[edge[1]]++;
            outDegree[edge[0]]++;
        }

        // find start node
        for (int i = 1; i <= length; i++) {
            if (inDegree[i] == 0 && outDegree[i] >= 2) {
                start = i;
                break;
            }
        }

        Node startNode = nodeList.get(start - 1);

        // check the graph starting from start node's children
        for (Node child : startNode.child) {
            if (!visited[child.number]) {
                checkGraph(child);
            }
        }

        // prepare the result
        answer[0] = start;
        answer[1] = doughnut;
        answer[2] = stick;
        answer[3] = eight;
        return answer;
    }

    // check each graph
    public static void checkGraph(Node startNode) {
        int[] cycles = new int[1];  // Array to hold cycle count
        Set<Integer> path = new HashSet<>();  // current path during DFS
        Arrays.fill(visited, false);  // Reset visited for each new check

        findCycle(startNode, path, cycles);

        if (cycles[0] == 0) {
            stick++;  // It's a stick graph
        } else if (cycles[0] == 1) {
            doughnut++;  // It's a doughnut graph
        } else {
            eight++;  // It's an 8-shaped graph
        }
    }

    // DFS to find cycles
    public static void findCycle(Node node, Set<Integer> path, int[] cycles) {
        // Add current node to the path
        path.add(node.number);

        // Explore each child node
        for (Node child : node.child) {
            // If child node is not visited
            if (!path.contains(child.number)) {
                findCycle(child, path, cycles);
            } else {
                cycles[0]++;  // Found a cycle
            }
        }

        // Remove current node from path (backtrack)
        path.remove(node.number);
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