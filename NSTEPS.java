import java.util.Scanner;

public class NSTEPS {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int x=s.nextInt();
            int y=s.nextInt();
            if(x==y||y==x-2){
                int flag=0;
                if(x==y) {
                    int cnt = 0;
                    int ans = 0;
                    while (cnt <x) {
                        if (flag == 0) {
                            ans = ans + 1;
                            flag = 1;
                        } else {
                               ans=ans+3;
                               flag=0;
                        }
                        cnt++;
                    }
                    System.out.println(ans);
                }
                else{
                    int ans=2;
                    int cnt=0;
                    while (cnt < y) {
                        if (flag == 0) {
                            ans = ans + 1;
                            flag = 1;
                        } else {
                            ans=ans+3;
                            flag=0;
                        }
                        cnt++;
                    }
                    System.out.println(ans);
                }
            }
            else{
                System.out.println("No Number");
            }

        }
    }
}
