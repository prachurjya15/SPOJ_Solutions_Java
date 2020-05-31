import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;



public class EGYPIZZA {
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
        StdIn s=new StdIn();
        int n=s.nextInt();
        HashMap<String,Double> hm1=new HashMap<>();
        hm1.put("1/4",0.25);
        hm1.put("3/4",0.75);
        hm1.put("1/2",0.5);
        int count=1;
        HashMap<Double,Integer> hm2=new HashMap<>();
        ArrayList<Double> arr=new ArrayList<>();
        hm2.put(0.25,0);
        hm2.put(0.5,0);
        hm2.put(0.75,0);
         for(int i=0;i<n;i++){
             String x=s.nextLine();
             x=x.trim();
//             arr.add(hm1.get(x));
             hm2.put(hm1.get(x), hm2.getOrDefault(hm1.get(x),0)+1);
         }
//         first i try to count the 1/4 and 3/4 requirements
        int a=0;
         int b=0;
         int c=0;
        if(hm2.containsKey(0.25)){
          a=hm2.get(0.25);}
        if(hm2.containsKey(0.5)){
          b=hm2.get(0.5);
        }
        if(hm2.containsKey(0.75)){
            c=hm2.get(0.75);
        }
         if(hm2.get(0.25).equals(hm2.get(0.75))){
             count=count+a;
             hm2.put(0.75,0);
             hm2.put(0.25,0);
             c=0;
             a=0;
         }
      else if(hm2.get(0.25)>hm2.get(0.75)){
          count=count+c;
          hm2.put(0.75,0);
          hm2.put(0.25,a-c);
          a=0;
          c=0;
         }
      else{
          count=count+c;
          hm2.put(0.75,0);
          hm2.put(0.25,0);
          a=c-a;
          c=0;
         }
      if(hm2.get(0.25)!=0){
          if(b%2==0){
              count=count+(b/2);
          }
          else{
              count=count+(b+1)/2;
              hm2.put(0.25,hm2.get(0.25)-2);
          }
          count=count+(int)Math.ceil((double)(hm2.get(0.25)*0.25));
      }
      else{
          if(b%2==0){
              count=count+(b/2);
          }
          else{
              count=count+(b+1)/2;
          }
      }

//        arr.sort(Collections.reverseOrder());
        System.out.println(count);
    }
}
