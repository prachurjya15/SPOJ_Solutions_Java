import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class PIGBANK {
    public static int getMinVal(int[] val,int[] w,int W,int n){
          int[] dp=new int[W+1];
          Arrays.fill(dp,-1);
          dp[0]=0;
          for(int i=1;i<=W;i++){
//              dp[i]=-1;
              for(int j=0;j<n;j++){
                  if(w[j]<=i && dp[i-w[j]]!=-1&&(dp[i]==-1 || dp[i]>=val[j]+dp[i-w[j]])){
                      dp[i]=dp[i-w[j]]+val[j];
                  }
              }
          }
          return dp[W];

    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int w1=s.nextInt();
            int w2=s.nextInt();
            int W=w2-w1;
            int n=s.nextInt();
            int[] val=new int[n];
            int[] w=new int[n];
            for(int i=0;i<n;i++){
                val[i]=s.nextInt();
                w[i]=s.nextInt();
            }
            int ans=getMinVal(val,w,W,n);
            if(ans==-1){
                System.out.println("This is impossible.");
            }
            else{
                System.out.println("The minimum amount of money in the piggy-bank is "+ans+".");
            }

        }
    }
}
