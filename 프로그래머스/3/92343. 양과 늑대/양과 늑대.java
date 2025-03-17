import java.util.*;
class Solution {
    int answer = 0;
    List<Node> nodeList = new ArrayList<>();
    List<Node> non_vistiedList = new ArrayList<>();
    public int solution(int[] info, int[][] edges) {

        for(int i = 0; i < info.length; i++) {
            Node node = new Node(i,info[i]);
            nodeList.add(node);
        }
        for(int[] edge : edges) {
            Node node1 = nodeList.get(edge[0]);
            Node node2 = nodeList.get(edge[1]);
            node1.add(node2);
            //node2.add(node1);
        }
        non_vistiedList.add(nodeList.get(0));
        dfs(0,non_vistiedList,0,0);
        return answer;
    }

    public void dfs(int nodeNum, List<Node> non_vistiedList, int wolf, int sheep){
        Node currentNode = nodeList.get(nodeNum);

        if(currentNode.type == 0){
            sheep++;
        }else if(currentNode.type == 1){
            wolf++;
        }

        if(wolf >= sheep){
            return;
        }
        answer = Math.max(sheep, answer);

        // 방문 안한 애들 넣기
        non_vistiedList.addAll(currentNode.neighbors);
        // 난 방문했음
        non_vistiedList.remove(nodeList.get(nodeNum));

        for(int i=0;i<non_vistiedList.size();i++){
            Node next = non_vistiedList.get(i);
            ArrayList<Node> newList = new ArrayList<>(non_vistiedList);
            dfs(next.number,newList, wolf,sheep);
        }
        return;
    }

    public class Node{
        int number;
        int type;
        ArrayList<Node> neighbors = new ArrayList<>();

        Node(int number,int type){
            this.number = number;
            this.type = type;
        }

        void add(Node edge){
            this.neighbors.add(edge);
        }
    }
}