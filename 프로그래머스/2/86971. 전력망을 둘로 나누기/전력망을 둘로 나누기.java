import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = -1;
        // 노드 리스트
        List<Node> nodeList = new ArrayList<>();

        // 노드 생성
        for(int i=0;i<n+1;i++){
            Node node = new Node(i);
            nodeList.add(node);
        }

        //노드 연결
        for(int[] w:wires){
            Node node1 = nodeList.get(w[0]);
            Node node2 = nodeList.get(w[1]);
            node1.add(node2);
            node2.add(node1);
        }

        int min = Integer.MAX_VALUE;
        // 노드 끊어가면서 확인 필요
        for(int i=0;i<wires.length;i++){
            Node parent = nodeList.get(wires[i][0]);
            for(Node child: parent.edge){
                int value1 = bfs(parent, child, nodeList, n);
                int value2 = bfs(child, parent, nodeList, n);

                min = Math.min(min,Math.abs(value1-value2));
            }

        }

        return min;
    }

    public int bfs(Node parent, Node child, List<Node> nodeList, int n) {
        int length = 0;
        for(int i=0;i<nodeList.size();i++){
            nodeList.get(i).visited = false;
        }

        // 방문 true로 연결 해제
        parent.visited = true;
        child.visited = true;

        // Queue 로 이어진 노드 길이 구해야됨
        Queue<Node> queue = new LinkedList<>();
        queue.add(parent);

        // 부모에서 연결된 노드 길이
        while(!queue.isEmpty()){
            Node current = queue.poll();
            for(int i=0;i<current.edge.size();i++){
                Node edge = current.edge.get(i);
                if(!edge.visited){
                    queue.add(edge);
                    edge.visited = true;
                    length++;
                }
            }
        }


        return length;
    }

    public class Node{
        int number;
        ArrayList<Node> edge;
        boolean visited;

        Node(int number){
            this.number = number;
            edge = new ArrayList<>();
        }

        void add(Node node){
            this.edge.add(node);
        }
    }
}