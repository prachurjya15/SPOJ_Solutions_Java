import java.math.BigInteger;
import java.util.Scanner;

public class PALIN {
    public static String next_Palindrome(String str){
         int len=str.length();
         String left=str.substring(0,len/2);
         String mid=str.substring(len/2,len-len/2);
         String right=str.substring(len/2);
         if(right.compareTo(reverse(left))<0){
             return left+mid+reverse(left);
         }
        String next=new BigInteger(left+mid).add(BigInteger.ONE).toString();
        System.out.println(next);
        return next+reverse(next).substring(mid.length());
    }
    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        s.nextLine();
        while(t-->0){
            String str=s.nextLine();
            System.out.println(next_Palindrome(str));
        }
    }
}
