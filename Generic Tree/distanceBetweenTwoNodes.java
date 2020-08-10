import java.util.*;

class Node{
    int data;
    ArrayList<Node> children = new ArrayList<>();
}

public class distanceBetweenTwoNodes {

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

   public static int distance(Node node, int n, int m){
       ArrayList d1 = ntrPath(node,n);
       ArrayList d2 = ntrPath(node,m);

        int i = d1.size()-1; 
        int j = d2.size()-1; 
        int c=0;
       while(i>=0 && j>=0 && d1.get(i)==d2.get(j)){
            c++;
            i--;
            j--;
       }
      i++;
      j++;
       return i+j;
   }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int ele = sc.nextInt();
        int ele1 = sc.nextInt();
        Node root=null;
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==-1){
                st.pop();
            }else{
                Node temp = new Node();
                temp.data = arr[i];
                if(st.size()==0){
                    root=temp;
                }else{
                    st.peek().children.add(temp);
                }
                st.push(temp);
            }
        }
       
        System.out.println(distance(root, ele, ele1));
    }
}
