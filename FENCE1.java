import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;
import java.io.*;

public class FENCE1 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while(true){
            int n=s.nextInt();
            if(n==0){
                break;
            }
            double r=(n*n)/(2*3.14159);
            DecimalFormat formatter = new DecimalFormat("#0.00");
            System.out.println(formatter.format(r));
        }
    }
}
