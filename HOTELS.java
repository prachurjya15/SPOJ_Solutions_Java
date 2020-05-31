import java.util.Scanner;

public class HOTELS {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int req_sum=s.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        int sum=0;
        int win_start=0;
        int ans=sum;
        for(int win_end=0;win_end<n;win_end++){
            sum=sum+arr[win_end];
            if(sum>req_sum){
                while(sum>req_sum && win_start<win_end){
                    sum=sum-arr[win_start];
                    win_start++;
                }
            }
            ans=Math.max(sum,ans);
        }
        System.out.println(ans);

    }
}
