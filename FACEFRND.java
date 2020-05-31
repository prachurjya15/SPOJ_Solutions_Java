import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class FACEFRND {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        HashSet<Integer> hs=new HashSet<>();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            hs.add(s.nextInt());
            int m=s.nextInt();
            for(int j=0;j<m;j++){
                hs.add(s.nextInt());
            }
        }
        System.out.println(hs.size()-n);
    }
}
