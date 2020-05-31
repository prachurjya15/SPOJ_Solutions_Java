import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BITMAP {
    public static int[] dr={-1,1,0,0};
    public static  int[] dc={0,0,-1,1};

    interface Input {
        public String next();
        public String nextLine();
        public int nextInt();
        public long nextLong();
        public double nextDouble();
    }
    static class StdIn implements Z_Outline.Input {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public StdIn() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public StdIn(String filename) {
            try{
                din = new DataInputStream(new FileInputStream(filename));
            } catch(Exception e) {
                throw new RuntimeException();
            }
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String next() {
            int c;
            while((c=read())!=-1&&(c==' '||c=='\n'||c=='\r'));
            StringBuilder s = new StringBuilder();
            while (c != -1)
            {
                if (c == ' ' || c == '\n'||c=='\r')
                    break;
                s.append((char)c);
                c=read();
            }
            return s.toString();
        }

        public String nextLine() {
            int c;
            while((c=read())!=-1&&(c==' '||c=='\n'||c=='\r'));
            StringBuilder s = new StringBuilder();
            while (c != -1)
            {
                if (c == '\n'||c=='\r')
                    break;
                s.append((char)c);
                c = read();
            }
            return s.toString();
        }

        public int nextInt() {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public int[] readIntArray(int n) {
            int[] ar = new int[n];
            for(int i=0; i<n; ++i)
                ar[i]=nextInt();
            return ar;
        }

        public long nextLong() {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public long[] readLongArray(int n) {
            long[] ar = new long[n];
            for(int i=0; i<n; ++i)
                ar[i]=nextLong();
            return ar;
        }

        public double nextDouble() {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() {
            try{
                if (bufferPointer == bytesRead)
                    fillBuffer();
                return buffer[bufferPointer++];
            } catch(IOException e) {
                throw new RuntimeException();
            }
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
    public static void bfs(char[][] arr,int[][] dist,int r,int c ){
        Queue<Integer> q1=new LinkedList<>();
        Queue<Integer> q2=new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]=='1'){
                    q1.add(i);
                    q2.add(j);
                }
            }
        }
        while(!q1.isEmpty()){
            int curr_row=q1.poll();
            int curr_col=q2.poll();
            int d=dist[curr_row][curr_col];
            for(int i=0;i<dr.length;i++){
                if(curr_row+dr[i]>=0 && curr_row+dr[i]<arr.length && curr_col+dc[i]>=0 && curr_col+dc[i]<arr[0].length){
                    if(d+1<dist[curr_row+dr[i]][curr_col+dc[i]] && arr[curr_row+dr[i]][curr_col+dc[i]]!='1'){
                        dist[curr_row+dr[i]][curr_col+dc[i]]=d+1;
                        q1.add(curr_row+dr[i]);
                        q2.add(curr_col+dc[i]);
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        StdIn s=new StdIn();
        int t=s.nextInt();
        StringBuilder str=new StringBuilder();
        while(t-->0){
            int n=s.nextInt();
            int m=s.nextInt();
            char[][] arr=new char[n][m];
            int[][] dist=new int[n][m];
            for(int i=0;i<n;i++){
                arr[i]=s.nextLine().toCharArray();
                for(int j=0;j<arr[i].length;j++){
                    if(arr[i][j]=='1'){
                        dist[i][j]=0;
                    }
                    else{
                        dist[i][j]=Integer.MAX_VALUE;
                    }
                }

            }
            bfs(arr,dist,0,3);
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[0].length;j++){
                    str.append(dist[i][j]).append(" ");
                }
                str.append("\n");
            }
        }
        System.out.println(str);
    }
}
