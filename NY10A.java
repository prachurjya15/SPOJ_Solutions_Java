import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NY10A {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        LinkedHashMap<String,Integer> hm=new LinkedHashMap<>();
        StringBuilder ans=new StringBuilder();
        while(t-->0){
            int n=s.nextInt();
            s.nextLine();
            hm.put("TTT",0);
            hm.put("TTH",0);
            hm.put("THT",0);
            hm.put("THH",0);
            hm.put("HTT",0);
            hm.put("HTH",0);
            hm.put("HHT",0);
            hm.put("HHH",0);
            String str=s.nextLine();
            for(int i=0;i<str.length()-2;i++){
                String temp=str.substring(i,i+3);
                hm.put(temp,hm.get(temp)+1);
            }
            ans.append(n).append(" ");
            for(Map.Entry<String,Integer> mp:hm.entrySet()){
                ans.append(mp.getValue()).append(" ");
            }
            ans.append("\n");
        }
        System.out.println(ans);
    }
}
