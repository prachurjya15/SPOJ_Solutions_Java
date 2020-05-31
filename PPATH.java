import java.util.*;

public class PPATH {
    public static int[] sieve(){
        int[] primes=new int[10000];
        primes[0]=0;
        primes[1]=0;
        primes[2]=1;
        for(int i=3;i<10000;i+=2){
            primes[i]=1;
        }
        for(int i=3;i<10000;i++){
            if(primes[i]==1){
                for(int j=i*i;j<10000;j+=i){
                    primes[j]=0;
                }
            }
        }
//        ArrayList<Integer> arr=new ArrayList<>();
//       for(int i=1000;i<primes.length;i++){
//           if(primes[i]==1){
//               arr.add(i);
//           }
//       }

       return primes;
    }
    public static int DigDiff(int a,int b){
        int count=0;
        while(a!=0 && b!=0){
            if(a%10!=b%10){
                count++;
            }
            a=a/10;
            b=b/10;
        }
        return count;
    }
    public static class Graph{
        int V;
        HashMap<Integer,ArrayList<Integer>> adjList=new HashMap<>();
        public void addEdge(int a,int b){
            if(!adjList.containsKey(a)){
                ArrayList<Integer> arr=new ArrayList<>();
                arr.add(b);
                adjList.put(a,arr);
            }
            else{
                ArrayList<Integer> arr=adjList.get(a);
                arr.add(b);
                adjList.put(a,arr);
            }
//            if(!adjList.containsKey(b)){
//                ArrayList<Integer> arr=new ArrayList<>();
//                arr.add(a);
//                adjList.put(b,arr);
//            }
//            else{
//                ArrayList<Integer> arr=adjList.get(b);
//                arr.add(a);
//                adjList.put(b,arr);
//            }

        }
        public HashMap<Integer, ArrayList<Integer>> getAdjList(){
            return adjList;
        }
    }
    public static int sssp(HashMap<Integer,ArrayList<Integer>> adjList,int src,int dest){
         int[] dist=new int[10000];
         Arrays.fill(dist,Integer.MAX_VALUE);
         dist[src]=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int curr_node=q.poll();
            int curr_dist=dist[curr_node];
            if(curr_node==dest){
                return curr_dist;
            }
            for(Integer ngh:adjList.get(curr_node)){
                if(dist[ngh]==Integer.MAX_VALUE){
                      dist[ngh]=curr_dist+1;
                      q.add(ngh);
                }
             }
        }
        return 0;
    }



    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
       int t=s.nextInt();
       int[]  primes=sieve();
        StringBuilder str=new StringBuilder();
        Graph g=new Graph();
        int n=1000;
        while(n<10000){
            int ans=Integer.MIN_VALUE;
            if(primes[n]==1){
                for(int j=n+1;j<10000;j++){
                    if(primes[j]==1){
                        if(DigDiff(n,j)==1){
                            g.addEdge(n,j);
                            g.addEdge(j,n);
                        }
                    }
                }
            }
            n++;
        }


        while(t-->0){
            int num1=s.nextInt();
            int num2=s.nextInt();
            ArrayList<Integer> arr=new ArrayList<>();
            HashMap<Integer,ArrayList<Integer>> adjList=g.getAdjList();
            str.append(sssp(adjList, num1, num2)).append("\n");
        }
        System.out.println(str);

    }
}
