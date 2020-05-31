import java.util.Scanner;

public class TRICOUNT {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            long n=s.nextLong();
            long ans=(n*(n+2)*(2*n+1))/8;
            System.out.println(ans);
        }
    }
}
