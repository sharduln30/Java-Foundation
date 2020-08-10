import java.util.*;
public class levelOrderLinewise{
    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static void display(Node root){
    
       Queue<Node> q = new ArrayDeque<>();
       Queue<Node> cq = new ArrayDeque<>();
       q.add(root);
       while(q.size()>0){
           Node node = q.remove();
           System.out.print(node.data+" ");
           for(Node child:node.children){
               cq.add(child);
            }
            if(q.size()==0){
                q=cq;
                cq=new ArrayDeque<>();
                System.out.println();
           }
       }
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