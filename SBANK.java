import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SBANK {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        StringBuilder ans=new StringBuilder();
        while(t-->0){
            int n=s.nextInt();
            s.nextLine();
            TreeMap<String,Integer> hm=new TreeMap<>();
            for(int i=0;i<n;i++){
                String str=s.nextLine();
                hm.put(str,hm.getOrDefault(str,0)+1);
            }
           for(Map.Entry<String,Integer> mp:hm.entrySet()){
               ans.append(mp.getKey()).append(" ").append(mp.getValue()).append("\n");
           }
           ans.append("\n");
        }
        System.out.println(ans);
    }
}
