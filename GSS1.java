import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.management.MemoryType;
import java.util.*;
class GSS1 {
    //    FAST I/O
   public static void buildTree(long[] tree,long[] arr,int s,int e,int idx){
        if(s==e){
            tree[idx]=arr[s];
            return;
        }
        int mid=s+((e-s)/2);
        buildTree(tree,arr,s,mid,2*idx);
        buildTree(tree,arr,mid+1,e,2*idx+1);
        tree[idx]=Math.max(Math.max(tree[2*idx]+tree[2*idx+1],tree[2*idx]),tree[2*idx+1]);
   }
   public static long query(long[] tree,int qs,int qe,int ss,int se,int idx){
//        Complete overlap
       if(ss>=qs && se<=qe){
           return tree[idx];
       }
//       out_of_bounds
       if(se<qs || ss>qe){
           return Integer.MIN_VALUE;
       }
       int mid=ss+((se-ss)/2);
       long left=query(tree,qs,qe,ss,mid,2*idx);
       long right=query(tree,qs,qe,mid+1,se,2*idx+1);
        if(left==Integer.MIN_VALUE){
            return right;
        }
        else if(right==Integer.MIN_VALUE){
            return left;
        }
        else{
            return Math.max(Math.max(left+right,left),right);
        }

   }

    public static void main(String[] args) {
       Scanner s=new Scanner(System.in);
        int t=1;
        StringBuilder str=new StringBuilder();
        while(t-->0){
             int n=s.nextInt();
             long[] arr=new long[n];
             for(int i=0;i<n;i++){
                 arr[i]=s.nextLong();
             }
             long[] tree=new long[4*n+1];
             buildTree(tree,arr,0,n-1,1);
             long query=s.nextLong();
             while(query-->0){
                 int qs=s.nextInt();
                 int qe=s.nextInt();
                 qs=qs-1;
                 qe=qe-1;
                 str.append(query(tree,qs,qe,0,n-1,1)).append("\n");
             }
        }
        System.out.println(str);
    }

}
