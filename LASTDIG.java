import java.util.Scanner;

public class LASTDIG {
    public static long binaryPow(int n,long p){
        n=n%10;
        long ans=1;
        while(p>0){
            if((p&1)==1){
                 ans=ans*n%10;
            }
            n=n*n%10;
            p=p>>1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
        int n=s.nextInt();
        long p=s.nextLong();
            System.out.println(binaryPow(n,p));


    }
    }
}
