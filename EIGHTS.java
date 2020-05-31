import java.util.Scanner;

public class EIGHTS {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            long k=s.nextLong();
            System.out.println(192+(k-1)*250);
        }
    }
}
