import java.util.Arrays;
import java.util.Scanner;

public class FASHION {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int[] men=new int[n];
            int[] women=new int[n];
            for(int i=0;i<n;i++){
                men[i]=s.nextInt();
            }
            for(int i=0;i<n;i++){
                women[i]=s.nextInt();
            }
            Arrays.sort(men);Arrays.sort(women);
            long ans=0;
            for(int i=0;i<n;i++){
                ans=ans+men[i]*women[i];
            }
            System.out.println(ans);
        }
    }
}
