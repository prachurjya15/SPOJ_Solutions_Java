import java.math.BigInteger;
import java.util.*;
class BISHOPS{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        StringBuilder str=new StringBuilder();
        while(s.hasNextBigInteger()){
            BigInteger n=s.nextBigInteger();
            if(n.equals(new BigInteger("1"))){
                System.out.println(1);
                continue;
            }
            if(n.equals(BigInteger.valueOf(0))){
                System.out.println(0);
                continue;
            }
            BigInteger ans=n.add(n.subtract(new BigInteger("2")));
            System.out.println(ans);
        }
    }
}