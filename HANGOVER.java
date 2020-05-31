import java.util.Scanner;

public class HANGOVER {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while(true){
            double num=s.nextDouble();
            if(num==0.00){
                break;
            }
            double a=2;
            double sum=1/a;
            int n=1;
            while(sum<num){
                a++;
                sum=sum+(1/(a));
                n++;
            }
            System.out.println(n+" "+"card(s)");
        }
    }
}
