import java.math.BigInteger;
import java.util.Scanner;

public class LASTDIG2 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        StringBuilder str=new StringBuilder();
        while(t-->0){
            BigInteger num=s.nextBigInteger();
            BigInteger pow=s.nextBigInteger();
            str.append(num.modPow(pow,BigInteger.valueOf(10))).append("\n");
        }
        System.out.println(str);
    }
}
