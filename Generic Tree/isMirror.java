import java.util.*;

class Node{
    int data;
    ArrayList<Node> children = new ArrayList<>();
}

public class isMirror {

    public static Node construct(int[] arr) {
        Node root = null;
    
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
          if (arr[i] == -1) {
            st.pop();
          } else {
            Node t = new Node();
            t.data = arr[i];
    
            if (st.size() > 0) {
              st.peek().children.add(t);
            } else {
              root = t;
            }
    
            st.push(t);
          }
        }
    
        return root;
      }
    

    public static void display(Node node){
        int d = node.data;
        System.out.print(d+" -> ");
        for(Node i:node.children){
            System.out.print(i.data+", ");
        }
        System.out.println(".");
        for(Node i:node.children){
            display(i);
        }
    }

    public static ArrayList<Integer> ntrPath(Node node, int ele){ 
        if(node.data==ele){
            ArrayList<Integer> base = new ArrayList<>();
            base.add(node.data);
            return base;
        }
    
        for(Node child:node.children){
            ArrayList<Integer> ptc = ntrPath(child,ele);
            if(ptc.size()>0){
                ptc.add(node.data);
                return ptc;
            }
        }
        return new ArrayList<>();
    }

   public static boolean isMir(Node node1, Node node2){
       if(node1.children.size()!=node2.children.size()){
           return false;
       }
       for(int i=0;i<node1.children.size();i++){
           int j = node2.children.size()-1-i;
           Node child1 = node1.children.get(i);
           Node child2 = node2.children.get(j);
           if(!isMir(child1,child2)){
               return false;
           }
       }
       return true;
   }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }
        
        Node root1=construct(arr1);
        Node root2=construct(arr2);

        System.out.println(isMir(root1, root2));
    }
}
