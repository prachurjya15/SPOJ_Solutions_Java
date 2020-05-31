import java.util.*;
public class ACPC10A {
    private static String removeTrailingZeros(double d) {
        return String.valueOf(d).replaceAll("[0]*$", "").replaceAll(".$", "");
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while(true){
            Float x=s.nextFloat();
            Float y=s.nextFloat();
            Float z=s.nextFloat();
            if(x==0 && y==0 && z==0){
                break;
            }
            if((x+z)/(2.0)==y){
                System.out.print("AP"+" ");
                System.out.println(removeTrailingZeros(x+((3)*(y-x))));
            }
            else{
                System.out.print("GP"+" ");
                float r=0;
                if(x!=0){
                    r=y/x;
                }
                else{
                    r=z/y;
                }
                System.out.println(removeTrailingZeros(x*r*r*r));
            }

        }

    }
}
