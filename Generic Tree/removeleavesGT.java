import java.util.*;

class Node{
    int data;
    ArrayList<Node> children = new ArrayList<>();
}

public class removeleavesGT {

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
    public static void removeleaves(Node node){
        for(int i=node.children.size()-1;i>=0;i--){
            Node child=node.children.get(i);
            if(child.children.size()==0){
                node.children.remove(child);
            }
        }
        
        for(Node child:node.children){
            removeleaves(child);
        }
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
        removeleaves(root);
        display(root);
    }
}
