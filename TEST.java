import java.util.Scanner;

public class TEST {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while(true){
            int a=s.nextInt();
            if(a==42){
                break;
            }
            else{
                System.out.println(a);
            }
        }
    }
}
