import java.text.DecimalFormat;
import java.util.Scanner;

public class MAXLN {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int k=1;k<=t;k++){
            int x=s.nextInt();
            double ans=Math.pow(2*x,2)+0.25;
            double io=(4*x*x)+0.25;
            DecimalFormat df = new DecimalFormat("#");
            df.setMaximumFractionDigits(2);
            String p=df.format(ans);
            System.out.println("Case "+k+": "+p);
        }
    }
}
