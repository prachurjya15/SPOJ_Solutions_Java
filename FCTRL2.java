import java.math.BigInteger;
import java.util.Scanner;

public class FCTRL2 {
    public static BigInteger findFact(BigInteger b){
        if(b.intValue()==1){
            return b;
        }
        return b.multiply(findFact(b.subtract(new BigInteger("1"))));
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            BigInteger b=BigInteger.valueOf(n);
            System.out.println(findFact(b));
        }

    }
}
