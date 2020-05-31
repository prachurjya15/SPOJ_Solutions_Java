import java.util.Scanner;

public class PARTY {
    public static int maybe=0;
    public static class Pair{
        int wght;
        int h;
        Pair(int wght,int h){
            this.wght=wght;
            this.h=h;
        }
    }

    public static Pair  getMaxHap(int[] w,int[] hap,int W,int n){
           int[][] dp=new int[n+1][W+1];
           for(int i=1;i<=n;i++){
               for(int j=1;j<=W;j++){
                   if(w[i-1]<=j){
                       dp[i][j]=Math.max(hap[i-1]+dp[i-1][j-w[i-1]],dp[i-1][j]);
                   }
                   else{
                       dp[i][j]=dp[i-1][j];
                   }
               }
           }
           int optimal_w=0;
           for(int i=0;i<dp[0].length;i++){
               if(dp[n][i]==dp[n][W]){
                   optimal_w=i;
                   break;
               }
           }
           return new Pair(optimal_w,dp[n][W]);
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        StringBuilder str=new StringBuilder();
        while(true){
            maybe=0;
            int W=s.nextInt();
             int n=s.nextInt();
             if(W==0 && n==W){
                break;
             }
            int[]  hap=new int[n];
            int[]  w=new int[n];
            for(int i=0;i<n;i++){
                w[i]=s.nextInt();
                hap[i]=s.nextInt();
            }
            Pair ans =getMaxHap(w,hap,W,n);
            str.append(ans.wght).append(" ").append(ans.h).append("\n");
        }
        System.out.println(str);
    }
}
