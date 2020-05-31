import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class STAMPS {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int sc=1;sc<=t;sc++){
            int req=s.nextInt();
            int n=s.nextInt();
            ArrayList<Integer> arr=new ArrayList<>();
            for(int i=0;i<n;i++){
                arr.add(i,s.nextInt());
            }
            arr.sort(Collections.reverseOrder());
            int sum=0;
            int fr=0;
            for(int i=0;i<n;i++){
                sum=sum+arr.get(i);
                fr++;
                if(sum>=req){
                    break;
                }
            }
            if(sum>=req){
                System.out.println("Scenario #"+sc+":");
                System.out.println(fr);
                System.out.println();
            }
            else{
                System.out.println("Scenario #"+sc+":");
                System.out.println("impossible");
                System.out.println();
            }
        }
    }
}
