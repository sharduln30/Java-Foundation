import java.util.ArrayList;
import java.util.Arrays;

class DSU{

    static ArrayList<ArrayList<Edge>> graph=new ArrayList<>();
    static ArrayList<ArrayList<Edge>> dsugraph=new ArrayList<>();


    static class Edge{

        int v;
        
        Edge(int v){
            this.v=v;
        }


    }

    static void add_edge(int u,int v,ArrayList<ArrayList<Edge>> g){
        g.get(u).add(new Edge(v));
    }

    static void display(ArrayList<ArrayList<Edge>> g){

        int i=0;
        for(ArrayList<Edge> arr:g){
              System.out.print(i+"=>");
            for(Edge ed:arr){
                System.out.print(ed.v+",");
            }
            System.out.println();
            i++;
        }
    }


    static int find(int vtx,int[] par){
        if(vtx==par[vtx]){
            return vtx;
        }

        return find(par[vtx], par);



    }


    static void union(int u,int v,int[] par,int[] child){
        if(child[u]>=child[v]){
               par[v]=u;
               child[u]++;
        }else{

            par[u]=v;
            child[v]++;

        }
    }

    static void dsu(){


        int[] par=new int[graph.size()];
        int[] child=new int[graph.size()];

        for(int i=0;i<graph.size();i++){
            par[i]=i;
            
        }

        Arrays.fill(child,1);
        // System.out.println(Arrays.toString(par));
        // System.out.println(Arrays.toString(child));


        for(int i=0;i<graph.size();i++){
            for(int j=0;j<graph.get(i).size();j++){
              Edge ed=graph.get(i).get(j);

              int par1=find(i,par);
              int par2=find(ed.v,par);

              if(par1==par2){
                  System.out.println("Cycle detect");
                  System.out.print(i+"->"+ed.v);
                  return;
                
              }

              union(par1,par2,par,child);
              add_edge(par1, par2, dsugraph);


            }
        }

        // System.out.println(Arrays.toString(par));
        // System.out.println(Arrays.toString(child));

        display(dsugraph);




    }



    public static void main(String[] args){

        graph.add(new ArrayList<Edge>());//0
        graph.add(new ArrayList<Edge>());//1
        graph.add(new ArrayList<Edge>());//2
        graph.add(new ArrayList<Edge>());//3
        graph.add(new ArrayList<Edge>());//4
        graph.add(new ArrayList<Edge>());//5
        graph.add(new ArrayList<Edge>());//6


        add_edge(0, 1, graph);
        add_edge(1, 2, graph);
        add_edge(2, 3, graph);
        // add_edge(3, 0, graph);
        // add_edge(3, 4, graph);
        add_edge(4, 5, graph);
        add_edge(5, 6, graph);

        // display(graph);\


        dsugraph.add(new ArrayList<Edge>());//0
        dsugraph.add(new ArrayList<Edge>());//1
        dsugraph.add(new ArrayList<Edge>());//2
        dsugraph.add(new ArrayList<Edge>());//3
        dsugraph.add(new ArrayList<Edge>());//4
        dsugraph.add(new ArrayList<Edge>());//5
        dsugraph.add(new ArrayList<Edge>());//6

        dsu();





    }
}