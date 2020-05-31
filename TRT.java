import java.util.Scanner;

public class TRT {
    public static long getMaxProfit(int[] prices,int start,int end,int year,long[][] memo){
        if(start>end){
            return 0;
        }
        if(start==end){
            return year*prices[start];
        }
        if(memo[start][end]!=-1){
            return memo[start][end];
        }

        return memo[start][end]=Math.max(year*prices[start]+getMaxProfit(prices,start+1,end,year+1,memo),
                         year*prices[end]+getMaxProfit(prices,start,end-1,year+1,memo));
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] prices=new int[n];
        for(int i=0;i<n;i++){
            prices[i]=s.nextInt();
        }
        long[][] memo=new long[n][n];
        for(int i=0;i<memo.length;i++){
            for(int j=0;j<memo[0].length;j++){
                memo[i][j]=-1;
            }
        }
        System.out.println(getMaxProfit(prices,0,n-1,1,memo));
    }
}
