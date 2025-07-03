import java.util.*;

/**
 * 백준 1759
 * 브루트포스 알고리즘
 * 백트래킹
 */
public class Main {
    static int L;
    static int C;
    static boolean[] visited;
    static char[] alphabet;
    static List<Character> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        visited = new boolean[C];
        alphabet = new char[C];
        list = new ArrayList<>();
        String input = sc.nextLine();
        input = sc.nextLine();

        for(int i=0,a=0;i<input.length();i+=2){
            alphabet[a++] = input.charAt(i);
        }
        Arrays.sort(alphabet);
        dfs(0);

    }

    public static void dfs(int index){
        if(list.size() == L){
            int cnt=0;
            if(!list.contains('a') && !list.contains('e') && !list.contains('i') && !list.contains('o') && !list.contains('u')){
                return;
            }else{
                for(int i=0;i<list.size();i++){
                    if(list.get(i)!='a' && list.get(i)!='e'&&list.get(i)!='i'&&list.get(i)!='o'&&list.get(i)!='u'){
                        cnt++;
                    }
                }
                if(cnt<2){
                    return;
                }
                
            }
            
            
            List<Character> answer = new ArrayList<>(list);
            Collections.sort(answer);
            for(int i=0;i<answer.size();i++){
                System.out.print(answer.get(i));
            }
            System.out.println();
            return;
        }
        for(int i=index; i<C;i++){
            if(!visited[i]){

                visited[i] = true;
                list.add(alphabet[i]);
                dfs(i+1);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }

    }
}



