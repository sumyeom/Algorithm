import java.util.*;
class Solution {
    //data -> code / date / maximum / remain
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        List<int[]> list = new ArrayList<>();
        
        switch(ext){
            case "code":
                for(int i=0;i<data.length;i++){
                    if(val_ext > data[i][0]){
                        list.add(data[i]);
                    }
                }
                break;
            case "date":
                for(int i=0;i<data.length;i++){
                    if(val_ext > data[i][1]){
                        list.add(data[i]);
                    }
                }
                break;
            case "maximum":
                for(int i=0;i<data.length;i++){
                    if(val_ext > data[i][2]){
                        list.add(data[i]);
                    }
                }
                break;
            case "remain":
                for(int i=0;i<data.length;i++){
                    if(val_ext > data[i][3]){
                        list.add(data[i]);
                    }
                }
                break;
        }     
        
        switch(sort_by){
            case "code":
                Collections.sort(list, (a, b) -> Integer.compare(a[0], b[0]));;
                break;
            case "date":
                Collections.sort(list, (a, b) -> Integer.compare(a[1], b[1]));
                break;
            case "maximum":
                Collections.sort(list, (a, b) -> Integer.compare(a[2], b[2]));
                break;
            case "remain":
                Collections.sort(list, (a, b) -> Integer.compare(a[3], b[3]));
                break;
        }
        
        
        return list.toArray(new int[list.size()][]);
    }
}