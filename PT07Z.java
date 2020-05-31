import java.util.*;

public class PT07Z {
    public static class Graph{
        int V;
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        Graph(int V) {
            for (int i = 0; i < V; i++) {
                ArrayList<Integer> temp = new ArrayList<>();
                adjList.add(i, temp);
            }
        }
        public void addEdge(int a,int b){
            ArrayList<Integer> arr=adjList.get(a-1);
            arr.add(b-1);
            adjList.remove(a-1);
            adjList.add(a-1,arr);
        }
        public ArrayList<ArrayList<Integer>> getAdjList(){
            return adjList;
        }
    }
    public static class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }

    public static Pair bfs(ArrayList<ArrayList<Integer>> adjList,int src,int V){
        boolean[] visited=new boolean[V];
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        int[] dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        visited[src]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            int curr_dist=dist[curr];
            for(Integer ngh:adjList.get(curr)){
                if(!visited[ngh]){
                    q.add(ngh);
                    visited[ngh]=true;
                    dist[ngh]=dist[curr]+1;
                }
            }
        }
//        System.out.println(Arrays.toString(dist));
        int max=Integer.MIN_VALUE;
        int ans=-1;
        for(int i=0;i<dist.length;i++){
            if(dist[i]>max){
                ans=i;
                max=dist[i];
            }
        }
        return new Pair(ans,max);
    }

    public static  int getPathLength(ArrayList<ArrayList<Integer>> adjList,int V){
        Pair p1=bfs(adjList,0,V);
        Pair p2=bfs(adjList,p1.first,V);
        return p2.second;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int V=s.nextInt();
        Graph g=new Graph(V);
        for(int i=0;i<V-1;i++){
            int a=s.nextInt();
            int b=s.nextInt();
            g.addEdge(a,b);
            g.addEdge(b,a);
        }
        ArrayList<ArrayList<Integer>> adjList=g.getAdjList();
        System.out.println(getPathLength(adjList,V));
    }
}
