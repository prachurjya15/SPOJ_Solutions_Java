import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class PERMUT2 {
    //    FAST I/O
    interface Input {
        public String next();
        public String nextLine();
        public int nextInt();
        public long nextLong();
        public double nextDouble();
    }
    static class StdIn implements Input {
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
    public static void main(String[] args) {
        StdIn in=new StdIn();
        while(true){
           int n=in.nextInt();
           if(n==0){
               break;
           }
           HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
           int[] arr1=new int[n];
           int[] arr2=new int[n];
           for(int i=0;i<n;i++){
               int num=in.nextInt();
               hm.put(num,i+1);
               arr1[i]=num;
           }
           for(int i=0;i<n;i++){
               arr2[i]=hm.get(i+1);
           }
           int flag=0;
           for(int i=0;i<n;i++){
               if(arr1[i]!=arr2[i]){
                   flag=1;
                   break;
               }
           }
           if(flag==0){
               System.out.println("ambiguous");
           }
           else{
               System.out.println("not ambiguous");
           }

        }

    }

}
