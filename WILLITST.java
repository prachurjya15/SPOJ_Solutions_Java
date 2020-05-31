import java.util.Scanner;

public class WILLITST {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        long n=s.nextLong();
        if(n==1){
            System.out.println("TAK");
        }
        if(n%2!=0){
            System.out.println("NIE");
        }
        else{
            do {
                n = n / 2;
            } while (n % 2 == 0);
            if(n!=1){
                System.out.println("NIE");
            }
            else{
                System.out.println("TAK");
            }


        }


    }
}
