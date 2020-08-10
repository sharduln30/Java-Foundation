import java.util.*;

class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
}

public class IterativePrePost {

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

    static class Pair {
        Node node;
        int state;
        Pair(Node node, int state){
            this.node=node;
            this.state = state;
        }
    }
    static void iterativePrePost(Node node) {
       Stack<Pair> st = new Stack<>();
       ArrayList<Integer> pre = new ArrayList<>();
       ArrayList<Integer> post = new ArrayList<>();

       st.push(new Pair(node,-1));
       while(st.size()>0){
          Pair top = st.peek();
            if(top.state==-1){
                pre.add(top.node.data);
                top.state++;
            }else if(top.state==top.node.children.size()){
                post.add(top.node.data);
                st.pop();
            }else{
                st.push(new Pair(top.node.children.get(top.state),-1));
                top.state++;
            }
       }
       for(int i:pre){
           System.out.print(i+" ");
       }
       System.out.println();
       for(int i:post){
        System.out.print(i+" ");
    }
    
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Node root = construct(arr);

        iterativePrePost(root);
    }
}
