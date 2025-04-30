import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        char aSick = sc.next().charAt(0);
        int aDegree = sc.nextInt();
        char bSick = sc.next().charAt(0);
        int bDegree = sc.nextInt();
        char cSick = sc.next().charAt(0);
        int cDegree = sc.nextInt();

        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;

        //각자 일단 보내
        if((aSick == 'Y' && aDegree >= 37)){
            A++;
        }else if((aSick == 'N' && aDegree >=37)){
            B++;
        }else if((aSick =='Y' && aDegree < 36)){
            C++;
        }else{
            D++;
        }

        if((bSick == 'Y' && bDegree >= 37)){
            A++;
        }else if((bSick == 'N' && bDegree >=37)){
            B++;
        }else if((bSick =='Y' && bDegree < 36)){
            C++;
        }else{
            D++;
        }

        if((cSick == 'Y' && cDegree >= 37)){
            A++;
        }else if((cSick == 'N' && cDegree >=37)){
            B++;
        }else if((cSick =='Y' && cDegree < 36)){
            C++;
        }else{
            D++;
        }

        if(A>=2){
            System.out.println("E");
        }else{
            System.out.println("N");
        }
    }
}