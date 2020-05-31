import java.util.Scanner;

public class MARBLES {
    public static long nCr(int n,int k){
        if(k>n-k){
            k=n-k;
        }
        long ans=1;
        for(int i=1;i<=k;i++){
            ans=ans*(n-i+1);
            ans=ans/i;
        }

        return ans;

    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        StringBuilder str=new StringBuilder();
        while(t-->0){
            int n=s.nextInt();
            int k=s.nextInt();
            if(n==k){
                str.append(1).append("\n");
            }
            else{
                str.append(nCr(n-1,k-1)).append("\n");
            }
        }
        System.out.println(str);
    }
}
