import java.util.Arrays;
import java.util.Scanner;

public class ACODE {
    public static long getCount(String arr,int n){
//        long ans=getCount(arr,n-1);
//        if(n-1>=0){
//            int num=arr[n-1]-'0';
//            int num2=arr[n]-'0';
//            if(num<2 ||(num==2 && num2<=6)){
//                ans=ans+getCount(arr,n-2);
//            }
//        }
        long[] dp=new long[n+1];
        dp[0]=1;
        dp[1]=arr.charAt(0)=='0'?0:1;
        for(int i=2;i<=n;i++){

            int oneDigit=Integer.parseInt(arr.substring(i-1,i));
            int TwoDigit=Integer.parseInt(arr.substring(i-2,i));
            if(oneDigit>=1){
                dp[i]=dp[i]+dp[i-1];
            }
            if(TwoDigit>=10 && TwoDigit<=26){
                dp[i]=dp[i]+dp[i-2];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while(true){
            String num=s.nextLine();
            if(num.equals("0")){
                break;
            }
            System.out.println(getCount(num,num.length()));
        }
    }
}
