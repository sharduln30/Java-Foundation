import java.util.ArrayList;
import java.util.LinkedList;

class bfs {
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


    static void bfsCall(int src){

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

    static void gcc(){

    }

    // ===============================================

    static void gcc(boolean[] visited, int i){
        LinkedList<Integer> q=new LinkedList<>();

        q.addLast(i);
        
        while(q.size()>0){
          int rem=q.removeFirst();
          visited[rem]=true;
           
          for(Edge ed:graph.get(rem)){
              if(!visited[ed.v])
                q.addLast(ed.v);
          }
        }
   
    }
    static void gccmain(){
        boolean[] visited = new boolean[graph.size()];
        int c=0;
        for(int i=0;i<graph.size();i++){
            if(!visited[i]){
                gcc(visited, i);
                c++;
            }
        }
        System.out.print(c);
    }

    // ====================================================
    static boolean isCyclic(boolean[] visited, int i){
        LinkedList<Integer> q=new LinkedList<>();

        q.addLast(i);
        int x =0;
        while(q.size()>0){
          int rem=q.removeFirst();
          
          if(visited[rem]){
              return true;
          }
          
          visited[rem]=true;
          for(Edge ed:graph.get(rem)){
              if(!visited[ed.v])
                q.addLast(ed.v);
          }
        }
        return false;
    }
    static void isCyclicMain(){
        boolean[] visited = new boolean[graph.size()];
  
        boolean flag=false;
        for(int i=0;i<graph.size();i++){
            if(!visited[i]){
                flag=flag || isCyclic(visited, i);
               
                if(flag){
                    System.out.println("Graph have cycle");
                    return;
                }
            }
        }
        System.out.println("Graph have not any cycle");
    }
    static boolean isConnected(boolean[] visited, int i){
        LinkedList<Integer> q=new LinkedList<>();

        q.addLast(i);
        int x =0;
        while(q.size()>0){
          int rem=q.removeFirst();
          
          if(visited[rem]){
              return true;
          }
          
          visited[rem]=true;
          for(Edge ed:graph.get(rem)){
              if(!visited[ed.v])
                q.addLast(ed.v);
          }
        }
        return false;
    }
    static void isConnectedMain(){
        boolean[] visited = new boolean[graph.size()];
        int c=0;
        // boolean flag=false;
        for(int i=0;i<graph.size();i++){
            if(!visited[i]){              
                if(!isConnected(visited, i)){
                    c++;
                }
            }
        }
        if(c==1){
            System.out.println("Complete graph is connected");
        }else{
            System.out.println("Complete graph is not connected");
            
        }
    }
    static class Pair{
        int l;
        int nbr;
    }
    
    static boolean isBipartite(boolean[] visited,int i, int[] level){
        LinkedList<Pair> q=new LinkedList<>();
        Pair p = new Pair();
        p.l = 1;
        p.nbr = i;
        q.addLast(p);
        while(q.size()>0){
          Pair rem=q.removeFirst();

          if(level[rem.nbr]!=0){
            if(rem.l%2!=level[rem.nbr]%2){
                return true;
            }
          }
         
          visited[rem.nbr] = true;
          level[rem.nbr] = rem.l;
          for(Edge ed:graph.get(rem.nbr)){
            if(!visited[ed.v]){
                 p = new Pair();
                p.nbr = ed.v;
                p.l = rem.l+1;
                q.addLast(p);
            }
        }
        }
        return false;
    }
    
    
    static void isBipartiteMain() {

        boolean[] visited = new boolean[graph.size()];
        int[] level = new int[graph.size()];

       boolean flag=false;
        for(int i=0;i<graph.size();i++){
            if(!visited[i]){       
                   flag = flag || isBipartite(visited, i, level);
            }
         }


            if(!flag){
                System.out.println("Bipartite");
            }
            else{
                System.out.println("Not Bipartite");
                
            }
        }
        
    

    static void BFS(){
       //  bfsCall(0);
       //  System.out.println();
       //  System.out.println((find(0,6)));
      //  gccmain();//get connected components
        // isCyclicMain();//any cyclic in gcc
       // isConnectedMain();//complete graph should be connected
        isBipartiteMain();

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
        // addEdge(5, 6, 8);
        addEdge(4, 6, 3);
    //    Display();
        BFS();
    }
}