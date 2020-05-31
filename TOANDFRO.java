import java.util.Scanner;

public class TOANDFRO {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while (true){
            int col=s.nextInt();
            if(col==0){
                break;
            }
            s.nextLine();
            String str=s.nextLine();
            char[][] ch=new char[str.length()/col][col];
            int idx=0;
            for(int i=0;i<ch.length;i++){
                for(int j=0;j<ch[0].length;j++){
                    ch[i][j]=str.charAt(idx);
                    idx++;
                }
            }
            for(int i=0;i<ch.length;i++){
                if(i%2!=0){
                    int start=0;
                    int end=ch[0].length-1;
                    while(start<=end){
                        char temp=ch[i][start];
                        ch[i][start]=ch[i][end];
                        ch[i][end]=temp;
                        start++;
                        end--;
                    }
                }
            }
            StringBuilder ans=new StringBuilder();
            for(int i=0;i<ch[0].length;i++){
                for(int j=0;j<ch.length;j++){
                    ans.append(ch[j][i]);
                }
            }
            System.out.println(ans);

//            for(int i=0;i<ch.length;i++){
//                for(int j=0;j<ch[0].length;j++){
//                    System.out.print(ch[i][j]+" ");
//                }
//                System.out.println();
//            }


        }
    }
}
