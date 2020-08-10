import java.util.*;
public class levelOrderLinewiseZigZag{
    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static void display(Node root){
    
       Stack<Node> q = new Stack<>();
       Stack<Node> cq = new Stack<>();
       q.push(root);
       int c=0;
       while(q.size()>0){
           Node node = q.pop();
           System.out.print(node.data+" ");
           if(c%2==0){
                for(Node child:node.children){
                    cq.push(child);
                }
            }else{
                for(int i=node.children.size()-1;i>=0;i--){
                    cq.push(node.children.get(i));
                }
            }
            if(q.size()==0){
                q=cq;
                cq=new Stack<>();
                System.out.println();
                c++;
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