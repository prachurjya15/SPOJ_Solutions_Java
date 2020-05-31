import java.util.*;

public class CANDY {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while(true){
            int n=s.nextInt();
            if(n==-1){
                break;
            }
            int[] arr=new int[n];
            int sum=0;
            for(int i=0;i<n;i++){
                arr[i]=s.nextInt();
                sum=sum+arr[i];
            }
            if(sum%n!=0){
                System.out.println(-1);
            }
            else{
                int r=sum/n;
                int ans=0;
//                Arrays.sort(arr);
                for(int i=0;i<n;i++){
                    if(arr[i]>r){
                        ans=ans+(arr[i]-r);
                    }
                }
                System.out.println(ans);
            }

        }
    }
}
