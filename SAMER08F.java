import java.util.Scanner;

public class SAMER08F {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while(true){
            int n=s.nextInt();
            if(n==0){
                break;
            }
            long ans=n*(n+1)*(2*n+1)/6;
            System.out.println(ans);
        }
    }
}
