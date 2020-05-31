import java.util.Scanner;

public class NGM {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        long n=s.nextLong();
        if(n%10==0){
            System.out.println(2);
        }
        else{
        System.out.println(1);
        System.out.println(n%10);
       }
    }
}
