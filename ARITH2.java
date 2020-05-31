import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ARITH2 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        s.nextLine();
        StringBuilder output=new StringBuilder();
        while(t-->0){
            StringBuilder x= new StringBuilder();
            String space=s.nextLine();
            do {
//                  char ch=s.next().charAt(0);
                String temp = s.next();
                for (int i = 0; i < temp.length(); i++) {
                    if (temp.charAt(i) != ' ' && temp.charAt(i) != '+' && temp.charAt(i) != '-' && temp.charAt(i) != '*' && temp.charAt(i) != '/' && temp.charAt(i) != '=') {
                        x.append(temp.charAt(i));
                    } else {
                        x.append(" ").append(temp.charAt(i)).append(" ");
                    }
                }

//                  System.out.println("temp"+temp);
            } while (!x.toString().contains("="));

            String str=x.toString();
            String[] arr=str.split(" ");
            int num_idx=2;
            int op_idx=1;
            long ans=Long.parseLong(arr[0]);
            while(num_idx<arr.length-1){
                String op=arr[op_idx];
                switch (op) {
                    case "*":
                        ans = ans * (Long.parseLong(arr[num_idx]));
                        break;
                    case "+":
                        ans = ans + (Long.parseLong(arr[num_idx]));
                        break;
                    case "-":
                        ans = ans - (Long.parseLong(arr[num_idx]));
                        break;
                    default:
                        ans = ans / (Long.parseLong(arr[num_idx]));
                        break;
                }
                num_idx=num_idx+2;
                op_idx=op_idx+2;
            }
            output.append(ans).append("\n");
        }
        System.out.println(output);
    }
}
