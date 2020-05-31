import java.util.Scanner;

public class ETF {
    public static int etf(int n){
        int result=n;
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                while(n%i==0){
                    n=n/i;
                }
                result=result-(result/i);
            }
        }
       if(n>1){
           result=result-(result/n);
       }
        return result;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        StringBuilder str=new StringBuilder();
        while(t-->0){
            int n=s.nextInt();
            str.append(etf(n)).append("\n");
        }
        System.out.println(str);
    }
}
