import java.util.HashSet;
import java.util.Scanner;

public class HPYNOS {
    public static long createNum(long n){
        long ans=0;
        while(n!=0){
            ans=ans+((n%10)*(n%10));
            n=n/10;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        long n=s.nextLong();
        HashSet<Long> hs=new HashSet<>();
        int c=0;
        while(n!=1){
            c++;
            n=createNum(n);
            if(hs.contains(n)){
                break;
            }
            hs.add(n);
        }
        if(n==1){
            System.out.println(c);
        }
        else{
            System.out.println(-1);
        }
    }
}
