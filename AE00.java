import java.util.Scanner;

public class AE00 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int ans=0;
        for(int i=1;i<=n;i++){
            int j=i*i;
            while(j<=n){
                ans++;
                j=j+i;
            }
        }
        System.out.println(ans);
    }
}
