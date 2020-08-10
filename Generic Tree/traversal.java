import java.util.*;
public class traversal {
    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static void display(Node root){
    
        System.out.println("Node Pre "+root.data);
        for(Node i:root.children){
            System.out.println("Edge Pre "+root.data+"--"+i.data);
            display(i);
            System.out.println("Edge Post "+root.data+"--"+ i.data);
        }
        System.out.println("Node Post "+root.data);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        Node root = null;
        Stack<Node> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==-1){
                st.pop();
            }else{
                Node node = new Node();
                node.data = arr[i];
                if(st.size()==0){
                    root=node;
                }else{
                    st.peek().children.add(node);
                }
                st.push(node);
            }
        }
        display(root);
    }
}