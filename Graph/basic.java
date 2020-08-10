
import java.util.ArrayList;
import java.util.LinkedList;

class basic {
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    static class Edge {
        int v;
        int wt;


        Edge(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    static void addEdge(int u, int v, int wt) {
        graph.get(u).add(new Edge(v, wt));
        graph.get(v).add(new Edge(u, wt));
    }

    static void Display() {

        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + "->");
            for (Edge ed : graph.get(i)) {
                System.out.print(" [ " + ed.v + "," + ed.wt + " ] ,");
            }
            System.out.println();
        }
    }
    
    static void removeEdge(int u, int v) {

        for (int i = 0; i < graph.get(u).size(); i++) {
            Edge ed = graph.get(u).get(i);
            if (ed.v == v) {
                graph.get(u).remove(ed);
            }
        }
        for (int i = 0; i < graph.get(v).size(); i++) {
            Edge ed = graph.get(v).get(i);
            if (ed.v == u) {
                graph.get(v).remove(ed);
            }
        }
    }

    static void removeVertex(int u) {

        for (int i = 0; i < graph.get(u).size(); i++) {
            Edge ver = graph.get(u).get(i);

            for (int j = 0; j < graph.get(ver.v).size(); j++) {
                Edge ed = graph.get(ver.v).get(j);
                if (ed.v == u) {
                    graph.get(ver.v).remove(ed);
                }
            }
        }

        for (int i = graph.get(u).size() - 1; i >= 0; i--) {
            Edge ver = graph.get(u).get(i);
            graph.get(u).remove(ver);
        }
    }

    static boolean dfs(int src,int v, boolean[] visited) {
        
        if(src == v){
            return true;
        }
        boolean flag = false;
        visited[src] = true;
        for(int i=0;i<graph.get(src).size();i++){
            Edge ed = graph.get(src).get(i);
            if(visited[ed.v]==false){
                flag = flag || dfs(ed.v, v, visited);
            }
        }
        visited[src] = false;
        return flag;
    }
    static void allPath(int src,int v, boolean[] visited,String str) {
        
        if(src == v){
            System.out.println(str+"->"+src);
            return;
        }
        boolean flag = false;
        visited[src] = true;
        for(int i=0;i<graph.get(src).size();i++){
            Edge ed = graph.get(src).get(i);
            if(visited[ed.v]==false){
                allPath(ed.v, v, visited,str+"->"+src);
            }
        }
        visited[src] = false;
        
    }
    static boolean hashPath(int src,int v, boolean[] visited,String str) {
        
        if(src == v){
            System.out.println(str+"->"+src);
            return true;
        }
        boolean flag = false;
        visited[src] = true;
        for(int i=0;i<graph.get(src).size();i++){
            Edge ed = graph.get(src).get(i);
            if(visited[ed.v]==false){
              flag=flag || hashPath(ed.v, v, visited,str+"->"+src);
            }
        }

        visited[src] = false;
        return flag;
    }
    static void hamiltonianPath(int src,int vdx,boolean[] visited, String str){

        if(vdx==graph.size()){
            System.out.println(str+"->"+src);
            return;
        }
        visited[src] = true;
        for(int i=0;i<graph.get(src).size();i++){
            Edge ed = graph.get(src).get(i);
            if(visited[ed.v]==false){
                hamiltonianPath(ed.v,vdx+1,visited,str+"->"+src);
            }
        }
        visited[src] = false;
    }
    // ===========
    static void hamiltonianCycle(int osrc,int src,int vdx,boolean[] visited, String str){

        if(vdx==graph.size()){

            for(int i=0;i<graph.get(src).size();i++){
                
                if(osrc==graph.get(src).get(i).v){

                    System.out.println(str+"->"+src+" *");
                    return;
                }
            }

            System.out.println(str+"->"+src+" .");
            return;
        }
        visited[src] = true;
        for(int i=0;i<graph.get(src).size();i++){
            Edge ed = graph.get(src).get(i);
            if(visited[ed.v]==false){
                hamiltonianCycle(osrc,ed.v,vdx+1,visited,str+"->"+src);
            }
        }
        visited[src] = false;
    }

    static void bfs(int src){

     LinkedList<Integer> q=new LinkedList<>();

     boolean[] visited=new boolean[graph.size()];

     q.addLast(src);
     
     while(q.size()>0){
       int rem=q.removeFirst();
       visited[rem]=true;
        
        System.out.print(rem+" ");
       for(Edge ed:graph.get(rem)){
           if(!visited[ed.v])
             q.addLast(ed.v);
       }
     }
    }

    static boolean find(int src,int data){

     LinkedList<Integer> q=new LinkedList<>();

     boolean[] visited=new boolean[graph.size()];

     q.addLast(src);
       boolean flag =false;
     while(q.size()>0){
       int rem=q.removeFirst();
       visited[rem]=true;
        if(rem == data){
            flag=true;
        }
        
       for(Edge ed:graph.get(rem)){
           if(!visited[ed.v])
             q.addLast(ed.v);
       }
        
     }
     return flag;
    }

    // ===============================================
     static void DFS(){
        boolean[] visited = new boolean[graph.size()];
        // System.out.println(dfs(0, 6, visited));
         // allPath(0, 6, visited, "");
         // hashPath(0, 6, visited, "");
         // Display();
         // hamiltonianPath(0,1,visited,"");
         hamiltonianCycle(0,0,1,visited,"");//orignal src,local src,vdx
     }
    // ===============================================
    // ===============================================

     static void BFS(){
         bfs(0);
         System.out.println();
         System.out.println((find(0,6)));
   
     }

    // ===============================================
    public static void main(String[] args) {

        graph.add(new ArrayList<Edge>());
        graph.add(new ArrayList<Edge>());
        graph.add(new ArrayList<Edge>());
        graph.add(new ArrayList<Edge>());
        graph.add(new ArrayList<Edge>());
        graph.add(new ArrayList<Edge>());
        graph.add(new ArrayList<Edge>());

        addEdge(0, 1, 10);
        addEdge(0, 3, 10);
        addEdge(1, 2, 2);
        addEdge(2, 3, 5);
        addEdge(3, 4, 6);
        addEdge(4, 5, 7);
        addEdge(5, 6, 8);
        addEdge(4, 6, 3);
        // addEdge(0, 6, 15);
        // addEdge(2, 5, 15);

        Display();
        // removeEdge(3,2);
        // removeVertex(4);
        System.out.println("###############################");
        // DFS();
        BFS();
    }
}