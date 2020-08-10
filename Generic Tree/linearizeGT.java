import java.util.*;

class Node{
    int data;
    ArrayList<Node> children = new ArrayList<>();
}

public class linearizeGT {

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
    public static Node getTail(Node node){
        while(node.children.size()==1){
            node = node.children.get(0);
        }
        return node;
    }
    public static void linear(Node node){ 
        for(Node child:node.children){
            linear(child);
        }
       while(node.children.size()>1){
            Node ln = node.children.remove(node.children.size()-1);
            Node sln = node.children.get(node.children.size()-1);
            // Node tail = sln.children.get(sln.children.size()-1);
            Node tail = getTail(sln);
            tail.children.add(ln);
       }
    }
    public static Node optimizelinear(Node node){
        if(node.children.size()==0){
            return node;
        }
        Node lt = optimizelinear(node.children.get(node.children.size()-1));
        while(node.children.size()>1){
            Node ln = node.children.remove(node.children.size()-1);
            Node sln = node.children.get(node.children.size()-1);
            Node slt = optimizelinear(sln);
            slt.children.add(ln);;
        }
        return lt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
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
        // linear(root);
        optimizelinear(root);
        display(root);
    }
}
