import java.util.Scanner;

public class FCTRL {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int p=5;
            int cnt=0;
            while(n>=p){
                cnt+=n/p;
                p=p*5;
            }
            System.out.println(cnt);
        }


    }
}
