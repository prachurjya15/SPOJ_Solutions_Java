import java.util.*;
public class COINS {
    public static long maxP(long n,HashMap<Long,Long> memo){
        if(n==0){
            return 0;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }
         memo.put(n,Math.max(n,maxP(n/2,memo)+maxP(n/3,memo)+maxP(n/4,memo)));
        return memo.get(n);
    }
    public static  int maxPBU(int n){
        int[] dp=new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            dp[i]=Math.max(i,dp[i/2]+dp[i/3]+dp[i/4]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=10;
        while(s.hasNextLong()){
            long n=s.nextInt();
            HashMap<Long,Long> memo=new HashMap<>();
            System.out.println(maxP(n,memo));
//            System.out.println(maxPBU(n));
        }
    }
}
