import java.util.ArrayList;
import java.util.*;

public class PRIME1 {
    public static void sieve(boolean[] sieve,ArrayList<Integer> primes){
        sieve[0]=false;
        sieve[1]=false;
        sieve[2]=true;
        for(int i=3;i<1000000;i+=2){
            sieve[i]=true;
        }
        for(int i=3;i<=1000;i+=2){
            if(sieve[i]){
            for(int j=i*i;j<1000000;j+=i){
                sieve[j]=false;
             }
            }
        }
        int idx=0;
        for(int i=0;i<sieve.length;i++){
            if(sieve[i]){
                primes.add(idx,i);
                idx++;
            }
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        ArrayList<Integer> primes=new ArrayList<>();
        boolean[] sieve=new boolean[1000000];
        sieve(sieve,primes);
        while(t-->0){
            int a=s.nextInt();
            int b=s.nextInt();
            if(a>b){
                int temp=a;
                a=b;
                b=temp;
            }
            int[] segment=new int[b-a+1];
            for(Integer p:primes){
                if(p*p>b){
                    break;
                }
                int start=(a/p)*p;
                if(start<a){
                    start=start+p;
                }
                if(p>=a && p<=b){
                    start=p*2;
                }
                for(int i=start;i<=b;i+=p){
                       segment[i-a]=1;
                }
            }

            for(int i=0;i<segment.length;i++){
                if(segment[i]==0){
                    if(i+a!=1) {
                        System.out.println(i + a);
                    }
                }
            }
            System.out.println();
        }
    }
}
