import java.util.Arrays;
import java.util.Scanner;

public class AMR10G {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        StringBuilder str=new StringBuilder();
        while(t-->0){
            int n=s.nextInt();
            int k=s.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=s.nextInt();
            }
            if(k==1){
                str.append(0).append("\n");
                continue;
            }
            Arrays.sort(arr);
            int ans=Integer.MAX_VALUE;
            for(int i=0;i<=n-k;i++){
                int diff=arr[i+k-1]-arr[i];
                ans=Math.min(diff,ans);
            }
            str.append(ans).append("\n");
        }
        System.out.println(str);
    }
}
