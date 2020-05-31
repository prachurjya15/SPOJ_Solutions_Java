import java.util.ArrayList;
import java.util.Scanner;

public class PT07Y {
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

    public static boolean isTree(ArrayList<ArrayList<Integer>> adjList,int V){
        boolean[] visited=new boolean[V];
            if(isCyclic(adjList,visited,0,-1)){
                return false;
            }
            for(int i=0;i<V;i++){
                if(!visited[i]){
                    return  false;
                }
            }
            return true;
    }
    public static boolean isCyclic(ArrayList<ArrayList<Integer>> adjList,boolean[] visited,int src,int p){
             visited[src]=true;
             for(Integer ngh:adjList.get(src)){
                 if(!visited[ngh]){
                     if(isCyclic(adjList,visited,ngh,src)){
                         return true;
                     }
                 }
                 else{
                     if(ngh!=p){
                         return true;
                     }

                 }

             }
             return false;

    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        Graph g=new Graph(n);
        int m=s.nextInt();
        for(int i=0;i<m;i++){
            int a=s.nextInt();
            int b=s.nextInt();
            g.addEdge(a,b);
            g.addEdge(b,a);
        }
        ArrayList<ArrayList<Integer>> adjList=g.getAdjList();
        boolean isTree=isTree(adjList,n);
        if(isTree){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
