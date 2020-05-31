import java.util.Arrays;
import java.util.Scanner;

public class OFFSIDE {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while(true){
            int A=s.nextInt();
            int D=s.nextInt();
            if(A==D && A==0){
                break;
            }
            int[] arr1=new int[A];
            int[] arr2=new int[D];
            for(int i=0;i<A;i++){
                arr1[i]=s.nextInt();
            }
            for(int i=0;i<D;i++){
                arr2[i]=s.nextInt();
            }
            Arrays.sort(arr1);Arrays.sort(arr2);
            if(arr1[0]>arr2[1]){
                System.out.println("N");
            }
            else if(arr1[0]==arr2[0] && arr2[0]==arr2[1]){
                System.out.println("N");
            }
            else if(arr1[0]==arr2[1]){
                System.out.println("N");
            }
            else{
                System.out.println('Y');
            }

        }

    }
}
