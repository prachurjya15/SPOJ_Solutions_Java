import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class AP2{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        StringBuilder ans=new StringBuilder();
        while(t-->0){
            long t_term=s.nextLong();
            long l_t_term=s.nextLong();
            long sum=s.nextInt();
            long n=2*(sum/(t_term+l_t_term));
            ans.append(n).append("\n");
            long d= (l_t_term-t_term)/(n-5);
            long a=t_term-2*d;
            for(long i=1;i<=n;i++){
                ans.append(a).append(" ");
                a+=d;
            }
            ans.append("\n");
        }
        System.out.println(ans);
    }

}
