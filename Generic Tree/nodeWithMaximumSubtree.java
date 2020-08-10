import java.util.*;

class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
}

public class nodeWithMaximumSubtree {

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

    public static void display(Node node) {
        int d = node.data;
        System.out.print(d + " -> ");
        for (Node i : node.children) {
            System.out.print(i.data + ", ");
        }
        System.out.println(".");
        for (Node i : node.children) {
            display(i);
        }
    }

    static int ceil;
    static int floor;

    public static void ceilNfloor(Node node, int data) {

        if (node.data > floor && node.data < data) {
            floor = node.data;
        }
        if (node.data > data && node.data < ceil) {
            ceil = node.data;

        }

        for (Node child : node.children) {
            ceilNfloor(child, data);
        }
    }

    static Node msn=null;
    static int ms= Integer.MIN_VALUE;
    public static int subtreeSum(Node node) {
        int sum=0;
        for(Node child:node.children){
            sum=0;
            subtreeSum(child);
            sum+=child.data;
        }  
        sum+=node.data;
        if(sum>ms){
            ms = sum;
            msn = node;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Node root = construct(arr);


         subtreeSum(root);
        System.out.println(msn.data +"@"+ms);

    }
}
