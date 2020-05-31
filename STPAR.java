import java.util.Scanner;
import java.util.Stack;

public class STPAR {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while(true){
            int n=s.nextInt();
            if(n==0){
                break;
            }
            int[] arr=new int[n];
            int s_el=1;
            Stack<Integer> st=new Stack<>();
            for(int i=0;i<n;i++){
                int num=s.nextInt();
                while (!st.isEmpty() && st.peek()==s_el){
                    st.pop();
                    s_el++;
                }
                if(num==s_el){
                    s_el++;
                }
                else{
                    st.push(num);
                }
            }
            while(!st.isEmpty() && st.peek()==s_el){
                st.pop();
                s_el++;
            }
            if(st.isEmpty()){
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }

        }
    }
}
