import java.util.Scanner;

public class CANDY3 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            long n=s.nextLong();
            if(n==0){
                System.out.println("YES");
                continue;
            }
            long sum=0;
            for(int i=0;i<n;i++){
                long num=s.nextLong();
                sum=((sum%n)+(num%n))%n;
            }
            if(sum==0){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }

        }
    }
}
