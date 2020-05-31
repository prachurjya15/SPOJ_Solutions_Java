import java.util.Arrays;
import java.util.Scanner;

public class MIXTURES {
    public static int cSum(int[] arr,int start,int end){
        int sum=0;
        for(int i=start;i<=end;i++){
            sum=sum+arr[i];
            sum=sum%100;
        }
        return sum;
    }

    public static int getMinSmoke(int[] arr,int start,int end,int[][] dp){
        if(start>=end){
            return 0;
        }
        if(dp[start][end]!=-1){
            return dp[start][end];
        }
        dp[start][end]=Integer.MAX_VALUE;
        for(int k=start;k<=end;k++){
            dp[start][end]=Math.min(dp[start][end],getMinSmoke(arr,start,k,dp)+getMinSmoke(arr,k+1,end,dp)+cSum(arr,start,k)*cSum(arr,k+1,end));
        }
        return dp[start][end];
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while(s.hasNextInt()){
            int n=s.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=s.nextInt();
            }
            int[][] dp=new int[arr.length][arr.length];
            for(int i=0;i<dp.length;i++){
                Arrays.fill(dp[i],-1);
            }
            System.out.println(getMinSmoke(arr,0,n-1,dp));
        }

    }
}
