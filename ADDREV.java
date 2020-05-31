import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ADDREV {
    public static  int reverse(int a){
          if(a%10==a){
              return a;
          }
          int num=0;
          while(a!=0){
              num=num*10+a%10;
              a=a/10;
          }
        return  num;


    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        s.nextLine();
        StringBuilder str=new StringBuilder();
        while(t-->0){
            int a=s.nextInt();
            int b=s.nextInt();
            a=reverse(a);
            b=reverse(b);
            int c=reverse(a+b);
            str.append(c).append("\n");
        }
        System.out.println(str);
    }
}

