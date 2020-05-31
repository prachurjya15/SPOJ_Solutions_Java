import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BUGLIFE {
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
               ArrayList<Integer> arr=adjList.get(a);
               arr.add(b);
               adjList.remove(a);
               adjList.add(a,arr);
        }
        public ArrayList<ArrayList<Integer>> getAdjList(){
            return adjList;
        }
    }
    public static boolean bfs(ArrayList<ArrayList<Integer>> adjList,int[] color,int V,int src){
        Queue<Integer> q=new LinkedList<>();
        color[src]=1;
        q.add(src);
        while(!q.isEmpty()){
            int curr=q.poll();
            int curr_col=color[curr];
            for(Integer x:adjList.get(curr)){
                if(color[x]==0){
                    color[x]=3-curr_col;
                    q.add(x);
                }
                else if(color[x]==curr_col){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        StringBuilder str=new StringBuilder();
        for(int k=1;k<=t;k++){
            int V=s.nextInt();
            int E=s.nextInt();
            Graph g=new Graph(V);
            for(int i=0;i<E;i++){
                int a=s.nextInt();
                int b=s.nextInt();
                g.addEdge(a-1,b-1);
                g.addEdge(b-1,a-1);
            }
            int[] color=new int[V];
            int flag=0;
            for(int i=0;i<color.length;i++) {
                if(color[i]==0){
                if(!bfs(g.getAdjList(), color, V, i)){
                    flag=1;
                    break;
                }
              }
            }
            str.append("Scenario #"+k+":").append("\n");
            if(flag==1){
                str.append("Suspicious bugs found!").append("\n");
            }else{
                str.append("No suspicious bugs found!").append("\n");
            }
        }
        System.out.println(str);
    }
}
