import java.util.Scanner;

public class INVCNT {
    public static long countCrosInv(int[] arr,int start,int end){
        int[] temp=new int[arr.length];
        int idx=start;
        int i=start;
        long count=0;
        int mid=start+(end-start)/2;
        int j=mid+1;
        while(i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                temp[idx++]=arr[i++];
            }
            else{
                count=count+mid-i+1;
                temp[idx++]=arr[j++];
            }
        }
        while(i<=mid){
            temp[idx++]=arr[i++];
        }
        while(j<=end){
            temp[idx++]=arr[j++];
        }

        for(int l=start;l<=end;l++){
            arr[l]=temp[l];
        }
        return count;
    }

    public static long countInversion(int[] arr,int start,int end){
        if(start>=end){
            return 0;
        }
        int mid=start+(end-start)/2;
        long l=countInversion(arr,start,mid);
        long r=countInversion(arr,mid+1,end);
        long crossInv=countCrosInv(arr,start,end);
        return l+r+crossInv;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=s.nextInt();
            }
            System.out.println(countInversion(arr,0,n-1));
        }
    }
}
