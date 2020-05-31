import java.util.Scanner;

public class HUBULLU {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        StringBuilder str=new StringBuilder();
        while(t-->0){
            long n=s.nextInt();
            int p=s.nextInt();
             if(p==1){
                 str.append("Pagfloyd wins.").append("\n");
             }
             else{
                 str.append("Airborne wins.").append("\n");
             }
        }
        System.out.println(str);
    }
}
