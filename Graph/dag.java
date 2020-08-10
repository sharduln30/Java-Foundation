import java.util.ArrayList;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Arrays;

class dag {
    
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
    
    static void ts(int src,boolean[] visited, Stack<Integer> st){
       
        visited[src] = true;
        for(int i=0;i<graph.get(src).size();i++){
            Edge ed = graph.get(src).get(i);
            if(visited[ed.v]==false){
                ts(ed.v, visited,st);
            }
        }
        st.push(src);
       
    }

    static void TopologicalSort(int src){
        boolean[] visited = new boolean[graph.size()];
        Stack<Integer> ver = new Stack<>();
        for(int i=0;i<graph.size();i++){
            if(!visited[i]){ 
                ts(i,visited,ver);
                
            }
        }
        while(ver.size()>0){
            System.out.print(ver.pop()+"\t");
        }
        
    }
    
    static boolean isCyclic(int src,boolean[] visited, Stack<Integer> st,boolean[] checked){
       
        visited[src] = true;
        checked[src]=true;
        boolean ans=false;
        for(int i=0;i<graph.get(src).size();i++){
            Edge ed = graph.get(src).get(i);
            if(checked[ed.v]){
                return true;
            }
            if(visited[ed.v]==false){   
               ans=isCyclic(ed.v, visited,st,checked);
            }
        }
        checked[src]=false;
        st.push(src);
       return ans;
    }

    static void isCyclicMain(){
        boolean[] visited = new boolean[graph.size()];
        boolean[] checked = new boolean[graph.size()];
        Stack<Integer> ver = new Stack<>();
        
        for(int i=0;i<graph.size();i++){
            if(!visited[i]){ 
              if(isCyclic(i,visited,ver,checked)){
                  System.out.println("DAG is Cyclic. TS not Possible!");
                  return;
              }
        
                
            }
        }
        while(ver.size()>0){
            System.out.print(ver.pop()+"\t");
        }
    }





    static void khansAlgo(int src){
        ArrayList<Integer> ans=new ArrayList<>();
        int[] indegree = new int[graph.size()];
       
        
        // its used for indegree array
        for(int i=0;i<graph.size();i++){  
             for(Edge ed:graph.get(i)){
                 indegree[ed.v]++;    
             }
            }
    //    System.out.println( Arrays.toString(indegree));

       LinkedList<Integer> q=new LinkedList<>();
       
       //we add the 0 indegree
       for(int i=0;i<indegree.length;i++){
           if(indegree[i]==0){
               q.addLast(i);
           }
       }

   
    while(q.size()>0){
        int rem=q.removeFirst();
        ans.add(rem);
        for(Edge ed:graph.get(rem)){
            indegree[ed.v]--;
            if(indegree[ed.v]==0){
                q.addLast(ed.v);
            }
        }
    }
    if(ans.size()==graph.size())
        System.out.println(ans);
    else
        System.out.println("DAG is cyclic. TS not possible");

    }

    public static void main(String[] args){
        
        graph.add(new ArrayList<Edge>());
        graph.add(new ArrayList<Edge>());
        graph.add(new ArrayList<Edge>());
        graph.add(new ArrayList<Edge>());
        graph.add(new ArrayList<Edge>());
        graph.add(new ArrayList<Edge>());
        graph.add(new ArrayList<Edge>());
        graph.add(new ArrayList<Edge>());
        
                                        
        addEdge(0,1,10);
        addEdge(1,2,20);
        addEdge(2,3,30);
        addEdge(0,4,40);
        addEdge(5,4,50);
        addEdge(5,6,60);
        addEdge(6,7,70);
        addEdge(7,3,80);
        addEdge(7,0,800);
        // addEdge(3,5,800);
        // Display();
        // TopologicalSort(0);
        // isCyclicMain();
        khansAlgo(0);

    }
}
