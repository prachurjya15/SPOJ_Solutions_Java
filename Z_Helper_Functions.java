import java.util.*;
public class Z_Helper_Functions {
//        Helper Functions
        public static class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
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


    public static int solve(){
        return 0;
    }



    public static void main(String[] args) {

    }
}
